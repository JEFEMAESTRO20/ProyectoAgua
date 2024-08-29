package com.ProyectoAgua.servicios.interfaces;

import com.ProyectoAgua.modelos.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    Page<Empleado> buscarTodosPaginados(Pageable pageable);

    List<Empleado> obtenerTodos();

    Optional<Empleado> buscarPorId(Integer id);

    Empleado crearOEditar(Empleado empleado);

    void eliminarPorId (Integer id);
}
