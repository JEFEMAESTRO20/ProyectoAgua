package com.ProyectoAgua.repositorios;

import com.ProyectoAgua.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
