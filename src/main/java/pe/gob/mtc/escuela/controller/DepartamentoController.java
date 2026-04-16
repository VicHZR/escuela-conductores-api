package pe.gob.mtc.escuela.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.gob.mtc.escuela.dto.DepartamentoDTO;
import pe.gob.mtc.escuela.entity.Departamento;
import pe.gob.mtc.escuela.repository.DepartamentoRepository;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoRepository repository;

    public DepartamentoController(DepartamentoRepository repository) {
        this.repository = repository;
    }

    /* =========================================================
       GET – BÚSQUEDA ESTÁNDAR / RÁPIDA
    ========================================================= */
    @GetMapping
    public List<Departamento> buscar(
            @RequestParam(defaultValue = "ESTANDAR") String tipoBusqueda,
            @RequestParam(required = false) String nombre
    ) {
        if ("RAPIDA".equalsIgnoreCase(tipoBusqueda) && nombre != null) {
            return repository.findByNombreIgnoreCaseContaining(nombre);
        }
        return repository.findByEstado('A');
    }

    /* =========================================================
       GET – POR ID
    ========================================================= */
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* =========================================================
       POST – INSERTAR
    ========================================================= */
    @PostMapping
    public ResponseEntity<Departamento> crear(@RequestBody Departamento departamento) {
        departamento.setEstado('A'); // activo por defecto
        Departamento guardado = repository.save(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    /* =========================================================
       PUT – ACTUALIZACIÓN COMPLETA
    ========================================================= */
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> actualizar(
            @PathVariable Integer id,
            @RequestBody Departamento data
    ) {
        Optional<Departamento> existente = repository.findById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Departamento dep = existente.get();
        dep.setNombre(data.getNombre());
        dep.setEstado(data.getEstado());

        return ResponseEntity.ok(repository.save(dep));
    }

    /* =========================================================
       PATCH – ACTUALIZACIÓN PARCIAL
    ========================================================= */
    @PatchMapping("/{id}")
    public ResponseEntity<Departamento> actualizarParcial(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> cambios
    ) {
        Optional<Departamento> existente = repository.findById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Departamento dep = existente.get();

        if (cambios.containsKey("nombre")) {
            dep.setNombre(cambios.get("nombre").toString());
        }

        if (cambios.containsKey("estado")) {
            dep.setEstado(cambios.get("estado").toString().charAt(0));
        }

        return ResponseEntity.ok(repository.save(dep));
    }

    /* =========================================================
       DELETE – ELIMINACIÓN LÓGICA
    ========================================================= */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Integer id) {
        Optional<Departamento> existente = repository.findById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Departamento dep = existente.get();
        dep.setEstado('I'); // Inactivo
        repository.save(dep);

        return ResponseEntity.noContent().build();
    }

    /* =========================================================
       GET – PAGINACIÓN Y ORDENAMIENTO (BD)
    ========================================================= */
    @GetMapping("/paginado")
    public Page<Departamento> listarPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "nombre,asc") String[] sort
    ) {
        Sort orden = Sort.by(
                "desc".equalsIgnoreCase(sort[1])
                        ? Sort.Direction.DESC
                        : Sort.Direction.ASC,
                sort[0]
        );

        Pageable pageable = PageRequest.of(page, size, orden);
        return repository.findByEstado('A', pageable);
    }

    /* =========================================================
       GET – PAGINACIÓN EN MEMORIA (DTO)
    ========================================================= */
    @GetMapping("/memoria")
    public List<DepartamentoDTO> listarEnMemoria(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<DepartamentoDTO> lista = repository.findByEstado('A')
                .stream()
                .map(d -> new DepartamentoDTO(d.getId(), d.getNombre()))
                .collect(Collectors.toList());

        int inicio = page * size;
        int fin = Math.min(inicio + size, lista.size());

        if (inicio >= lista.size()) {
            return List.of();
        }
        return lista.subList(inicio, fin);
    }
    
    
    @GetMapping("/hateoas/{id}")
    public ResponseEntity<EntityModel<Departamento>> obtenerHateoas(@PathVariable Integer id) {

        return repository.findById(id)
                .map(departamento -> {

                    EntityModel<Departamento> recurso = EntityModel.of(departamento);

                    recurso.add(
                        linkTo(methodOn(DepartamentoController.class)
                            .obtenerHateoas(id))
                            .withSelfRel()
                    );

                    recurso.add(
                        linkTo(methodOn(DepartamentoController.class)
                            .buscar("ESTANDAR", null))
                            .withRel("listar")
                    );

                    recurso.add(
                        linkTo(methodOn(DepartamentoController.class)
                            .eliminarLogico(id))
                            .withRel("desactivar")
                    );

                    return ResponseEntity.ok(recurso);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/hateoas")
    public CollectionModel<EntityModel<Departamento>> listarHateoas() {

        List<EntityModel<Departamento>> departamentos = repository.findByEstado('A')
                .stream()
                .map(dep -> EntityModel.of(dep,
                        linkTo(methodOn(DepartamentoController.class)
                            .obtenerHateoas(dep.getId()))
                            .withSelfRel()
                ))
                .toList();

        return CollectionModel.of(departamentos,
                linkTo(methodOn(DepartamentoController.class)
                    .listarHateoas())
                    .withSelfRel()
        );
    }
    
    
}