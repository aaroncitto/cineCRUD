package org.example.service;

import org.example.model.Entrada;
import org.example.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public Entrada guardarEntrada(Entrada entrada) {
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