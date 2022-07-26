package ar.com.argentinaprograma.backend.controller;

import ar.com.argentinaprograma.backend.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducacionController extends JpaRepository <Educacion, Long>{
}

