package ar.com.argentinaprograma.backend.controller;

import ar.com.argentinaprograma.backend.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaController extends JpaRepository <Experiencia, Long>{
}
