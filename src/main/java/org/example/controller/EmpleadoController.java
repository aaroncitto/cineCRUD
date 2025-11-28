package org.example.controller;

import org.example.model.Empleado;
import org.example.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> listarTodos() {
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado buscarPorId(@PathVariable Integer id) {
        return empleadoService.buscarPorId(id);
    }

    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Integer id, @RequestBody Empleado empleado) {
        Empleado existente = empleadoService.buscarPorId(id);
        if (existente != null) {
            existente.setNombre(empleado.getNombre());
            existente.setPuesto(empleado.getPuesto());
            existente.setTipoJornada(empleado.getTipoJornada());
            existente.setEmail(empleado.getEmail());
            existente.setTelefono(empleado.getTelefono());
            existente.setSalarioHora(empleado.getSalarioHora());
            existente.setActivo(empleado.getActivo());
            existente.setFechaContratacion(empleado.getFechaContratacion());
            return empleadoService.guardarEmpleado(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        empleadoService.borrarEmpleado(id);
    }
}