
package org.example;

import org.example.model.Empleado;
import org.example.service.EmpleadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ProyectoAccesoDatosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoAccesoDatosApplication.class, args);
    }
}