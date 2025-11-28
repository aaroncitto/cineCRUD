package org.example.controller;

import org.example.model.Proyecciones;
import org.example.service.ProyeccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proyecciones")
public class ProyeccionesController {

    @Autowired
    private ProyeccionesService proyeccionesService;

    @GetMapping("/{id}")
    public Proyecciones buscarPorId(@PathVariable Integer idProyeccion){
        return proyeccionesService.buscarPorId(idProyeccion);
    }

    @PostMapping
    public Proyecciones crear(@RequestBody Proyecciones proyecciones){
        return  proyeccionesService.guardarProyeccion(proyecciones);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer idProyeccion){
        proyeccionesService.borrarProyeccion(idProyeccion);
    }
}
