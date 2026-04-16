package pe.gob.mtc.escuela.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.mtc.escuela.entity.Departamento;

public interface DepartamentoRepository
        extends JpaRepository<Departamento, Integer> {

    List<Departamento> findByEstado(Character estado);

    List<Departamento> findByNombreIgnoreCaseContaining(String nombre);

    Page<Departamento> findByEstado(Character estado, Pageable pageable);
}