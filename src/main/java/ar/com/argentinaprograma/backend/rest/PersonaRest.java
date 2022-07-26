package ar.com.argentinaprograma.backend.rest;

import ar.com.argentinaprograma.backend.controller.PersonaController;
import ar.com.argentinaprograma.backend.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persona/")
@CrossOrigin (origins = "http://localhost:4200/")
public class PersonaRest {

    @Autowired
    private PersonaController personaController;
// VER TODOS
    @GetMapping("listar")
    public List<Persona> listarPersonas(){
        return personaController.findAll();
    } 
//GUARDAR
    @PostMapping("nueva")
    public Persona guardarPersona(@RequestBody Persona persona){
        return personaController.save(persona);
    }
//BUSCAR POR ID
    @GetMapping("{id}")
    public Optional<Persona> buscarPorId(@PathVariable("id") Long id){
        return personaController.findById(id);
    }
//BUSCAR POR NOMBRE
    @GetMapping("{nombre}")
    public Optional<Persona> buscarPorNombre(@PathVariable("nombre") String nombre) {
        return personaController.findByNombre(nombre);
    }
//BUSCAR POR APELLIDO    
    @GetMapping("{apellido}")
    public Optional<Persona> buscarPorApellido(@PathVariable("apellido") String apellido) {
        return personaController.findByApellido(apellido);
    }
//BORRAR POR ID
    @DeleteMapping("borrar/{id}")
    public String borrarPorId(@PathVariable("id") Long id){
        personaController.deleteById(id);
        return "Se eliminó la persona con ID"+" "+"'"+id+"'"+" "+"corractamente.";
    }
    
// ACTUALIZAR
    @PutMapping("editar")
    public Persona editarPersona(@RequestBody Persona persona){
        personaController.save(persona);
        return persona;        
    }

//EDITAR
    @PutMapping("editar/{id}")
    public String editarPersona(@PathVariable("id") Long id, @RequestBody Persona persona) {
        Persona pnew=personaController.findById(id).orElse(null);
        //pregunto si no es nulo, entonces edito el existente
        if(pnew!=null){
            pnew.setAcerca_de(persona.getAcerca_de());
            pnew.setApellido(persona.getApellido());
            pnew.setCiudad(persona.getCiudad());
            pnew.setEmail(persona.getEmail());
            pnew.setFecha_nac(persona.getFecha_nac());
            pnew.setNombre(persona.getNombre());
            pnew.setNombre_usuario(persona.getNombre_usuario());
            pnew.setPais(persona.getPais());
            pnew.setPassword(persona.getPassword());
            pnew.setProvincia(persona.getProvincia());
            pnew.setPuesto(persona.getPuesto());
            pnew.setTelefono(persona.getTelefono());
            pnew.setUrl_img(persona.getUrl_img());
            personaController.save(pnew);
            return "Se editó la persona con ID"+" "+"'"+id+"'"+" "+"corractamente.";
        }

        else { //si es nulo, no exite entonces lo creo
            // personaController.save(persona);
            return "No se encontró la persona con ID"+" "+"'"+id+"'";

        }

    }
}
