package com.ProyectoAgua.servicios.implementaciones;

import com.ProyectoAgua.modelos.Mora;
import com.ProyectoAgua.repositorios.IMoraRepository;
import com.ProyectoAgua.servicios.interfaces.IMoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoraService implements IMoraService {
    @Autowired
    private IMoraRepository moraRepository;

    @Override
    public Page<Mora> buscarTodosPaginados(Pageable pageable) {
        return moraRepository.findAll(pageable);
    }

    @Override
    public List<Mora> obtenerTodos() {
        return moraRepository.findAll();
    }

    @Override
    public Optional<Mora> buscarPorId(Integer id) {
        return moraRepository.findById(id);
    }

    @Override
    public Mora crearOEditar(Mora mora) {
        return moraRepository.save(mora);
    }

    @Override
    public void eliminarPorId(Integer id) {
        moraRepository.deleteById(id);

    }
}
