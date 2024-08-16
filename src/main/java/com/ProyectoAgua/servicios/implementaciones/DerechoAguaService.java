package com.ProyectoAgua.servicios.implementaciones;

import com.ProyectoAgua.modelos.DerechoAgua;
import com.ProyectoAgua.repositorios.IDerechoAguaRepository;
import com.ProyectoAgua.servicios.interfaces.IDerechoAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DerechoAguaService implements IDerechoAguaService {

    @Autowired
    private IDerechoAguaRepository derechoAguaRepository;

    @Override
    public Page<DerechoAgua> buscarTodosPaginados(Pageable pageable) {
        return derechoAguaRepository.findAll(pageable);
    }

    @Override
    public List<DerechoAgua> obtenerTodos() {
        return derechoAguaRepository.findAll();
    }

    @Override
    public Optional<DerechoAgua> buscarPorId(Integer id) {
        return derechoAguaRepository.findById(id);
    }

    @Override
    public DerechoAgua crearOEditar(DerechoAgua derechoAgua) {
        return derechoAguaRepository.save(derechoAgua);
    }

    @Override
    public void eliminarPorId(Integer id) {
        derechoAguaRepository.deleteById(id);
    }
}
