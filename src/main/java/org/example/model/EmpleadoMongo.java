package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "empleados") // Esto le dice a Mongo que guarde aquí
public class EmpleadoMongo {

    @Id
    private String id;
    private String nombre;
    private String puesto;
    private String tipoJornada;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
    private BigDecimal salarioHora;
    private Boolean activo;

    public EmpleadoMongo() {}

    public EmpleadoMongo(String nombre, String puesto, String tipoJornada, String email, String telefono, LocalDate fechaContratacion, BigDecimal salarioHora, Boolean activo) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.tipoJornada = tipoJornada;
        this.email = email;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.salarioHora = salarioHora; // <--- ¡Asegúrate de que esta variable está también arriba en el paréntesis!
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(BigDecimal salarioHora) {
        this.salarioHora = salarioHora;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}