package org.example.service;

import org.example.model.Empleado;
import org.example.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public void borrarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }

    public Empleado buscarPorId(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }
}