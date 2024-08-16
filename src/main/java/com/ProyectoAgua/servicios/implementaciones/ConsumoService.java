package com.ProyectoAgua.servicios.implementaciones;

import com.ProyectoAgua.modelos.Consumo;
import com.ProyectoAgua.repositorios.IConsumoRepository;
import com.ProyectoAgua.servicios.interfaces.IConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConsumoService implements IConsumoService {
    @Autowired
    private IConsumoRepository consumoRepository;

    @Override
    public Page<Consumo> buscarTodosPaginados(Pageable pageable) {
        return consumoRepository.findAll(pageable);
    }

    @Override
    public List<Consumo> obtenerTodos() {
        return consumoRepository.findAll();
    }

    @Override
    public Optional<Consumo> buscarPorId(Integer id) {
        return consumoRepository.findById(id);
    }

    @Override
    public Consumo crearOEditar(Consumo consumo) {
        return consumoRepository.save(consumo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        consumoRepository.deleteById(id);
    }
}
