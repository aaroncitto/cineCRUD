package org.example.service;

import org.example.model.Pelicula;
import org.example.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }


    public void borrarPelicula(Integer id) {
        peliculaRepository.deleteById(id);
    }

    // Y aquí también
    public Pelicula buscarPorId(Integer id) {
        return peliculaRepository.findById(id).orElse(null);
    }
}