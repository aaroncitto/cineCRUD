package org.example.service;

import org.example.model.Proyeccion;
import org.example.repository.ProyeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyeccionService {

    @Autowired
    private ProyeccionRepository proyeccionRepository;

    public Proyeccion guardarProyeccion(Proyeccion proyeccion) {
        return proyeccionRepository.save(proyeccion);
    }

    public List<Proyeccion> listarProyecciones() {
        return proyeccionRepository.findAll();
    }

    public void borrarProyeccion(Integer id) {
        proyeccionRepository.deleteById(id);
    }

    public Proyeccion buscarPorId(Integer id) {
        return proyeccionRepository.findById(id).orElse(null);
    }
}