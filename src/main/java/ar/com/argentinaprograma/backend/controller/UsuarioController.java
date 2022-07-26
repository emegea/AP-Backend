package ar.com.argentinaprograma.backend.controller;

import ar.com.argentinaprograma.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioController extends JpaRepository<Usuario,Integer>{
    Usuario findByUsername(String username); 
    Usuario findByUsernameAndPassword(String username,String password); 
    Usuario findByEmailAndPassword(String email, String password);
}