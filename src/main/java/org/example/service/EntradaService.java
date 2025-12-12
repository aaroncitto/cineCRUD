package org.example.service;

import org.example.model.Entrada;
import org.example.model.Proyeccion;
import org.example.repository.EntradaRepository;
import org.example.repository.ProyeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private ProyeccionRepository proyeccionRepository;

    public Entrada guardarEntrada(Entrada entrada) {

        Proyeccion proyeccion = proyeccionRepository.findById(entrada.getIdProyeccion()).orElseThrow(()-> new RuntimeException("Error: La proyeccion no existe"));
        if (proyeccion.getAsientosDisponibles()<=0){
            throw new RuntimeException("Error: La sala esta llena");
        }
        proyeccion.setAsientosDisponibles(proyeccion.getAsientosDisponibles()-1);
        proyeccionRepository.save(proyeccion);

        if (entrada.getFechaCompra()== null) {
            entrada.setFechaCompra(LocalDateTime.now());
        }

        return entradaRepository.save(entrada);
    }

    public List<Entrada> listarEntradas() {
        return entradaRepository.findAll();
    }

    public void borrarEntrada(Integer id) {
        entradaRepository.deleteById(id);
    }

    public Entrada buscarPorId(Integer id) {
        return entradaRepository.findById(id).orElse(null);
    }
}