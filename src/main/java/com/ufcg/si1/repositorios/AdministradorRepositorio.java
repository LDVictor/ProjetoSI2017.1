package com.ufcg.si1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufcg.si1.model.Administrador;

@Repository

public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {
}
