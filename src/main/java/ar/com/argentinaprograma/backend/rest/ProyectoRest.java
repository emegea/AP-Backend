package ar.com.argentinaprograma.backend.rest;

import ar.com.argentinaprograma.backend.controller.ProyectoController;
import ar.com.argentinaprograma.backend.model.Proyecto;
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
@CrossOrigin (origins = "https://portfolio-argentina-prog-e585f.web.app")
@RequestMapping("/api/proyecto/")
public class ProyectoRest {

    @Autowired
    private ProyectoController proyectoController;
// VER TODOS
    @GetMapping("listar")
    public List<Proyecto> listar(){
        return proyectoController.findAll();
    } 
//GUARDAR
@PostMapping("nueva")
    public Proyecto saveProyecto(@RequestBody Proyecto proyecto){
        return proyectoController.save(proyecto);
    }
//BUSCAR POR ID
    @GetMapping("{id}")
    public Optional<Proyecto> findById(@PathVariable("id") Long id){
        return proyectoController.findById(id);
    }
//BORRAR POR ID
    @DeleteMapping("borrar/{id}")
    public String deleteById(@PathVariable("id") Long id){
        proyectoController.deleteById(id);
        return "Se eliminó el proyecto con ID:"+" "+id+" "+"corractamente.";
    }

//EDITAR
    @PutMapping("editar/{id}")
    public String editarProyecto(@PathVariable("id") Long id, @RequestBody Proyecto proyecto) {
        Proyecto pnew=proyectoController.findById(id).orElse(null);
        //pregunto si no es nulo, entonces edito el existente
        if(pnew!=null){
            pnew.setTitulo_proyecto(proyecto.getTitulo_proyecto());
            pnew.setUrl_proyecto(proyecto.getUrl_proyecto());
            pnew.setImg_proyecto(proyecto.getImg_proyecto());
            pnew.setDescripcion_proyecto(proyecto.getDescripcion_proyecto());
            proyectoController.save(pnew);
            return "Se editó el proyecto con ID:"+" "+id+" "+"corractamente.";
        }

        else { //si es nulo, no exite entonces lo creo
            // proyectoController.save(proyecto);
            return "No se encontró el proyecto con ID:"+" "+id+".";

        }

    }
}

