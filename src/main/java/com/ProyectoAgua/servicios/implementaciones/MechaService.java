package com.ProyectoAgua.servicios.implementaciones;

import com.ProyectoAgua.modelos.Mecha;
import com.ProyectoAgua.repositorios.IMechaRepository;
import com.ProyectoAgua.servicios.interfaces.IMechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechaService implements IMechaService {
    @Autowired
    private IMechaRepository mechaRepository;

    @Override
    public Page<Mecha> buscarTodosPaginados(Pageable pageable) {
        return mechaRepository.findAll(pageable);
    }

    @Override
    public List<Mecha> obtenerTodos() {
        return mechaRepository.findAll();
    }

    @Override
    public Optional<Mecha> buscarPorId(Integer id) {
        return mechaRepository.findById(id);
    }

    @Override
    public Mecha crearOEditar(Mecha mecha) {
        return mechaRepository.save(mecha);
    }

    @Override
    public void eliminarPorId(Integer id) {
        mechaRepository.deleteById(id);
    }
}
