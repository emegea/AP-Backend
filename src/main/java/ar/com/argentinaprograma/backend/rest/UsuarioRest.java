package ar.com.argentinaprograma.backend.rest;

import ar.com.argentinaprograma.backend.controller.UsuarioController;
import ar.com.argentinaprograma.backend.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "https://ap-frontend.netlify.app")
@RequestMapping("/api/usuario/")
public class UsuarioRest {
    
    @Autowired
    private UsuarioController userController;
    
    
    //agregar (funciona)
    @PostMapping("agregar")
    public void newUser(@RequestBody Usuario u){
        userController.save(u);
    }
    
    //buscar todos (funciona)
      @GetMapping("listar")
    public List<Usuario> listar(){
        return userController.findAll();
    } 
    
    //buscar usuario por id (funciona)
    @GetMapping("buscar/{id}")
    @ResponseBody
    public Usuario usuario(@PathVariable Integer id){
        return(userController.findById(id).get());
    }
    
    //buscar por nombre de usuario (funciona)
    @GetMapping("buscar/username")
    @ResponseBody
    public Usuario usuario(){
        return(userController.findByUsername("marto"));
    }
    
    @PostMapping("login")
    @ResponseBody
    public Usuario login(@RequestBody Usuario u){
    return(userController.findByEmailAndPassword(u.getEmail(), u.getPassword()));
    }
    
    //editar
    @PutMapping("editar")
    public void editUser(@RequestBody Usuario u){
        userController.save(u);
    }
    
    //borrar por id (funciona)
    @DeleteMapping("borrar/{id}")
    public void deleteUser(@PathVariable Integer id){
        userController.deleteById(id);
    }
   
}