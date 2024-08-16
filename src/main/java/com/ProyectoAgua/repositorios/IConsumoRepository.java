package com.ProyectoAgua.repositorios;

import com.ProyectoAgua.modelos.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsumoRepository extends JpaRepository<Consumo, Integer> {
}
