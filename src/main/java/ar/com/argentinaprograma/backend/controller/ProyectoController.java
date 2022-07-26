package ar.com.argentinaprograma.backend.controller;

import ar.com.argentinaprograma.backend.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoController extends JpaRepository<Proyecto, Long> {
    
}

