package com.ProyectoAgua.servicios.interfaces;

import com.ProyectoAgua.modelos.Mecha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMechaService {
    Page<Mecha> buscarTodosPaginados(Pageable pageable);

    List<Mecha> obtenerTodos();

    Optional<Mecha> buscarPorId(Integer id);

    Mecha crearOEditar(Mecha mecha);

    void eliminarPorId (Integer id);
}
