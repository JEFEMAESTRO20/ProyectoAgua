package com.ProyectoAgua.servicios.interfaces;

import com.ProyectoAgua.modelos.Mora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMoraService {
    Page<Mora> buscarTodosPaginados(Pageable pageable);

    List<Mora> obtenerTodos();

    Optional<Mora> buscarPorId(Integer id);

    Mora crearOEditar(Mora mora);

    void eliminarPorId (Integer id);
}
