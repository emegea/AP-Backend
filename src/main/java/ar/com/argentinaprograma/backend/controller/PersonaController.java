package ar.com.argentinaprograma.backend.controller;

import ar.com.argentinaprograma.backend.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaController extends JpaRepository<Persona, Long> {
    public Optional<Persona> findByNombre(String nombre);
    public Optional<Persona> findByApellido(String apellido);
}