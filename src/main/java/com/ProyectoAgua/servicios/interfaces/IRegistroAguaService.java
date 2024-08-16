package com.ProyectoAgua.servicios.interfaces;

import com.ProyectoAgua.modelos.RegistroAgua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRegistroAguaService {
    Page<RegistroAgua> buscarTodosPaginados(Pageable pageable);

    List<RegistroAgua> obtenerTodos();

    Optional<RegistroAgua> buscarPorId(Integer id);

    RegistroAgua crearOEditar(RegistroAgua registroAgua);

    void eliminarPorId (Integer id);
}
