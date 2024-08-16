package com.ProyectoAgua.repositorios;

import com.ProyectoAgua.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
