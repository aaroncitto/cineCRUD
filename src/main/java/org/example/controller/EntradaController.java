package org.example.controller;

import org.example.model.Entrada;
import org.example.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @GetMapping
    public List<Entrada> listarTodas() {
        return entradaService.listarEntradas();
    }

    @GetMapping("/{id}")
    public Entrada buscarPorId(@PathVariable Integer id) {
        return entradaService.buscarPorId(id);
    }

    @PostMapping
    public Entrada crear(@RequestBody Entrada entrada) {
        return entradaService.guardarEntrada(entrada);
    }

    @PutMapping("/{id}")
    public Entrada actualizar(@PathVariable Integer id, @RequestBody Entrada entrada) {
        Entrada existente = entradaService.buscarPorId(id);
        if (existente != null) {
            existente.setIdProyeccion(entrada.getIdProyeccion());
            existente.setFechaCompra(entrada.getFechaCompra());
            existente.setCantidad(entrada.getCantidad());
            existente.setPrecioUnitario(entrada.getPrecioUnitario());
            existente.setTotal(entrada.getTotal());
            existente.setMetodoPago(entrada.getMetodoPago());
            existente.setAsiento(entrada.getAsiento());
            return entradaService.guardarEntrada(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        entradaService.borrarEntrada(id);
    }
}