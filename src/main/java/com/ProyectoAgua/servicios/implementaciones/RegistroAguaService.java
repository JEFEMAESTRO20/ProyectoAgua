package com.ProyectoAgua.servicios.implementaciones;

import com.ProyectoAgua.modelos.RegistroAgua;
import com.ProyectoAgua.repositorios.IDerechoAguaRepository;
import com.ProyectoAgua.repositorios.IRegistroAguaRepository;
import com.ProyectoAgua.servicios.interfaces.IRegistroAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroAguaService implements IRegistroAguaService {

    @Autowired
    private IRegistroAguaRepository registroAguaRepository;

    @Override
    public Page<RegistroAgua> buscarTodosPaginados(Pageable pageable) {
        return registroAguaRepository.findAll(pageable);
    }

    @Override
    public List<RegistroAgua> obtenerTodos() {
        return registroAguaRepository.findAll();
    }

    @Override
    public Optional<RegistroAgua> buscarPorId(Integer id) {
        return registroAguaRepository.findById(id);
    }

    @Override
    public RegistroAgua crearOEditar(RegistroAgua registroAgua) {
        return registroAguaRepository.save(registroAgua);
    }

    @Override
    public void eliminarPorId(Integer id) {
        registroAguaRepository.deleteById(id);
    }
}
