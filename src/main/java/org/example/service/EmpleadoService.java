package org.example.service;

import org.example.model.Empleado;
import org.example.model.EmpleadoMongo;
import org.example.repository.EmpleadoMongoRepository;
import org.example.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoMongoRepository empleadoMongoRepository;

    public Empleado guardarEmpleado(Empleado empleado) {
        // 1. Guardar en SQL
        Empleado empleadoGuardado = empleadoRepository.save(empleado);

        // 2. Crear objeto Mongo (Copia y pega este bloque tal cual)
        EmpleadoMongo empleadoMongo = new EmpleadoMongo(
                empleadoGuardado.getNombre(),
                empleadoGuardado.getPuesto(),
                empleadoGuardado.getTipoJornada().toString(),
                empleadoGuardado.getEmail(),
                String.valueOf(empleadoGuardado.getTelefono()),
                empleadoGuardado.getFechaContratacion(),
                empleadoGuardado.getSalarioHora(),
                empleadoGuardado.getActivo()
        );

        // 3. Guardar en Mongo
        empleadoMongoRepository.save(empleadoMongo);

        return empleadoGuardado;
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

    // Este método usa el repositorio de Mongo para traer todos los documentos
    public List<EmpleadoMongo> listarTodosDeMongo() {
        return empleadoMongoRepository.findAll();
    }

}