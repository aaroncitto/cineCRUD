package org.example.controller;

import org.example.model.Proyeccion;
import org.example.service.ProyeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecciones")
public class ProyeccionController {

    @Autowired
    private ProyeccionService proyeccionService;

    @GetMapping
    public List<Proyeccion> listarTodas() {
        return proyeccionService.listarProyecciones();
    }

    @GetMapping("/{id}")
    public Proyeccion buscarPorId(@PathVariable Integer id) {
        return proyeccionService.buscarPorId(id);
    }

    @PostMapping
    public Proyeccion crear(@RequestBody Proyeccion proyeccion) {
        return proyeccionService.guardarProyeccion(proyeccion);
    }

    @PutMapping("/{id}")
    public Proyeccion actualizar(@PathVariable Integer id, @RequestBody Proyeccion proyeccion) {
        Proyeccion existente = proyeccionService.buscarPorId(id);
        if (existente != null) {
            existente.setIdPelicula(proyeccion.getIdPelicula());
            existente.setIdSala(proyeccion.getIdSala());
            existente.setFechaHoraInicio(proyeccion.getFechaHoraInicio());
            existente.setFechaHoraFin(proyeccion.getFechaHoraFin());
            existente.setPrecioEntrada(proyeccion.getPrecioEntrada());
            existente.setAsientosDisponibles(proyeccion.getAsientosDisponibles());
            return proyeccionService.guardarProyeccion(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        proyeccionService.borrarProyeccion(id);
    }
}