package org.example.controller;

import org.example.model.Pelicula;
import org.example.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> listarTodas() {
        return peliculaService.listarPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula buscarPorId(@PathVariable Integer id) {
        return peliculaService.buscarPorId(id);
    }

    @PostMapping
    public Pelicula crear(@RequestBody Pelicula pelicula) {
        return peliculaService.guardarPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
        Pelicula existente = peliculaService.buscarPorId(id);
        if (existente != null) {
            existente.setTitulo(pelicula.getTitulo());
            existente.setDirector(pelicula.getDirector());
            existente.setDuracionMinutos(pelicula.getDuracionMinutos());
            existente.setGenero(pelicula.getGenero());
            existente.setClasificacion(pelicula.getClasificacion());
            existente.setSinopsis(pelicula.getSinopsis());
            existente.setFechaEstreno(pelicula.getFechaEstreno());
            existente.setPopularidad(pelicula.getPopularidad());
            existente.setActiva(pelicula.getActiva());
            existente.setFechaBaja(pelicula.getFechaBaja());
            return peliculaService.guardarPelicula(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        peliculaService.borrarPelicula(id);
    }
    @DeleteMapping("/{name}")
    public void borrar(@PathVariable String name) {
   //     peliculaService.borrarPelicula(name);
    }
}