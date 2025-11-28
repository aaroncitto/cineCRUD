package org.example.service;

import org.example.model.Proyecciones;
import org.example.repository.ProyeccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyeccionesService {

    @Autowired
    private ProyeccionesRepository proyeccionesRepository;

    public Proyecciones guardarProyeccion(Proyecciones proyecciones){
        return proyeccionesRepository.save(proyecciones);
    }

    public List<Proyecciones> listarProyecciones(){
        return proyeccionesRepository.findAll();
    }

    public void borrarProyeccion(Integer idProyeccion){
        proyeccionesRepository.deleteById(idProyeccion);
    }

    public Proyecciones buscarPorId (Integer idProyeccion) {
        return proyeccionesRepository.findById(idProyeccion).orElse(null);
    }
}
