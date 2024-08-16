package com.ProyectoAgua.repositorios;

import com.ProyectoAgua.modelos.DerechoAgua;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDerechoAguaRepository extends JpaRepository<DerechoAgua, Integer> {
}
