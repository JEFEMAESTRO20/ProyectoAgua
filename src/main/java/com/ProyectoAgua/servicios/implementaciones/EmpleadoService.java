package com.ProyectoAgua.servicios.implementaciones;

import com.ProyectoAgua.modelos.Empleado;
import com.ProyectoAgua.repositorios.IEmpleadoRepository;
import com.ProyectoAgua.servicios.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public Page<Empleado> buscarTodosPaginados(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    @Override
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> buscarPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado crearOEditar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarPorId(Integer id) {
        empleadoRepository.deleteById(id);
    }

}
