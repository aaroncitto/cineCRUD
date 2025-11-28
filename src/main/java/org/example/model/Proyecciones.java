package org.example.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "proyecciones")

public class Proyecciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyeccion")
    private  Integer idProyeccion;

    @Column(name = "id_pelicula")
    private  Integer idPelicula;

    @Column(name = "id_sala")
    private  Integer idSala;

    @Column(name = "fecha_hora_inicio")
    private  LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @Column(name = "precio_entrada")
    private BigDecimal precioEntrada;

    @Column(name = "asientos_disponibles")
    private  Integer asientosDispo;

    public Integer getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(Integer idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public BigDecimal getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(BigDecimal precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public Integer getAsientosDispo() {
        return asientosDispo;
    }

    public void setAsientosDispo(Integer asientosDispo) {
        this.asientosDispo = asientosDispo;
    }

}
