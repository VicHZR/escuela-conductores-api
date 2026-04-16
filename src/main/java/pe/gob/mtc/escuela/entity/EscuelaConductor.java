package pe.gob.mtc.escuela.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "escuela_conductor")
public class EscuelaConductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   // ✅ INTEGER (NO Long)

    @Column(name = "razon_social", nullable = false, length = 200)
    private String razonSocial;

    @Column(length = 300)
    private String direccion;

    @Column(nullable = false)
    private Character estado;

    @ManyToOne
    @JoinColumn(name = "distrito_id")
    private Distrito distrito;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // ===== GETTERS & SETTERS =====

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}