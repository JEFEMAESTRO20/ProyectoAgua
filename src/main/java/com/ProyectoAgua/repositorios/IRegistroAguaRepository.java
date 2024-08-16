package com.ProyectoAgua.repositorios;

import com.ProyectoAgua.modelos.RegistroAgua;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistroAguaRepository extends JpaRepository<RegistroAgua, Integer> {
}
