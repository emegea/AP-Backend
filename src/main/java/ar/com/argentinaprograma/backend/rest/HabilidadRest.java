package ar.com.argentinaprograma.backend.rest;

import ar.com.argentinaprograma.backend.controller.HabilidadController;
import ar.com.argentinaprograma.backend.model.Habilidad;
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
// @CrossOrigin (origins = "http://localhost:4200")
// @CrossOrigin (origins = "https://ap-frontend.netlify.app")
@CrossOrigin (origins = "https://ap-frontend-emegea.web.app/")

@RequestMapping("/api/habilidad/")
public class HabilidadRest {

    @Autowired
    private HabilidadController habilidadController;
// VER TODOS
    @GetMapping("listar")
    public List<Habilidad> listar(){
        return habilidadController.findAll();
    } 
//GUARDAR
@PostMapping("nueva")
    public Habilidad saveHabilidad(@RequestBody Habilidad habilidad){
        return habilidadController.save(habilidad);
    }
//BUSCAR POR ID
    @GetMapping("{id}")
    public Optional<Habilidad> findById(@PathVariable("id") Long id){
        return habilidadController.findById(id);
    }
//BORRAR POR ID
    @DeleteMapping("borrar/{id}")
    public String deleteById(@PathVariable("id") Long id){
        habilidadController.deleteById(id);
        return "Se eliminĂ³ la habilidad con ID:"+" "+id+" "+"corractamente.";
    }

//EDITAR
    @PutMapping("editar/{id}")
    public String editarHabilidad(@PathVariable("id") Long id, @RequestBody Habilidad habilidad) {
        Habilidad pnew=habilidadController.findById(id).orElse(null);
        //pregunto si no es nulo, entonces edito el existente
        if(pnew!=null){
            pnew.setPorcentaje(habilidad.getPorcentaje());
            pnew.setTitulo_habilidad(habilidad.getTitulo_habilidad());
            habilidadController.save(pnew);
            return "Se editĂ³ la habilidad con ID:"+" "+id+" "+"corractamente.";
        }

        else { //si es nulo, no exite entonces lo creo
            // habilidadController.save(habilidad);
            return "No se encontrĂ³ la habilidad con ID:"+" "+id+".";

        }

    }
}
