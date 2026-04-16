package pe.gob.mtc.escuela.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "distrito")
public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   // ✅ INTEGER (ANTES ERA Long)

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Character estado;

    @ManyToOne
    @JoinColumn(name = "provincia_id", nullable = false)
    private Provincia provincia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}