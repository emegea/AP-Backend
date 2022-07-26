package ar.com.argentinaprograma.backend.controller;

import ar.com.argentinaprograma.backend.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadController extends JpaRepository <Habilidad, Long>{
}
