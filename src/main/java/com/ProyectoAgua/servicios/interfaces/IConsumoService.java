package com.ProyectoAgua.servicios.interfaces;

import com.ProyectoAgua.modelos.Consumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IConsumoService {
    Page<Consumo> buscarTodosPaginados(Pageable pageable);

    List<Consumo> obtenerTodos();

    Optional<Consumo> buscarPorId(Integer id);

    Consumo crearOEditar(Consumo consumo);

    void eliminarPorId (Integer id);
}
