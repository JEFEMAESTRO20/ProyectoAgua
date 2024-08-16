package com.ProyectoAgua.repositorios;

import com.ProyectoAgua.modelos.Mecha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMechaRepository extends JpaRepository<Mecha, Integer> {
}
