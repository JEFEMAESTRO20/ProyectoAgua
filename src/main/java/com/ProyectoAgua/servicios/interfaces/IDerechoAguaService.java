package com.ProyectoAgua.servicios.interfaces;

import com.ProyectoAgua.modelos.DerechoAgua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDerechoAguaService {
    Page<DerechoAgua> buscarTodosPaginados(Pageable pageable);

    List<DerechoAgua> obtenerTodos();

    Optional<DerechoAgua> buscarPorId(Integer id);



    DerechoAgua crearOEditar(DerechoAgua derechoAgua);

    void eliminarPorId (Integer id);


    Object buscarTodos();
}
