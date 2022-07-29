package ar.com.argentinaprograma.backend.rest;

import ar.com.argentinaprograma.backend.controller.EducacionController;
import ar.com.argentinaprograma.backend.model.Educacion;
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
@CrossOrigin (origins = "https://portfolio-argentina-prog-e585f.web.app, http://localhost:4200")
@RequestMapping("/api/educacion/")
public class EducacionRest {

    @Autowired
    private EducacionController educacionController;
// VER TODOS
    @GetMapping("listar")
    public List<Educacion> listar(){
        return educacionController.findAll();
    } 
//GUARDAR
@PostMapping("nueva")
    public Educacion saveEducacion(@RequestBody Educacion educacion){
        return educacionController.save(educacion);
    }
//BUSCAR POR ID
    @GetMapping("{id}")
    public Optional<Educacion> findById(@PathVariable("id") Long id){
        return educacionController.findById(id);
    }
//BORRAR POR ID
    @DeleteMapping("borrar/{id}")
    public String deleteById(@PathVariable("id") Long id){
        educacionController.deleteById(id);
        return "Se eliminó la educacion con ID:"+" "+id+" "+"corractamente.";
    }

//EDITAR
    @PutMapping("editar/{id}")
    public String editarEducacion(@PathVariable("id") Long id, @RequestBody Educacion educacion) {
        Educacion pnew=educacionController.findById(id).orElse(null);
        //pregunto si no es nulo, entonces edito el existente
        if(pnew!=null){
            pnew.setTitulo_educacion(educacion.getTitulo_educacion());
            pnew.setLocalidad(educacion.getLocalidad());
            pnew.setInstitucion(educacion.getInstitucion());
            pnew.setUrl_diploma(educacion.getUrl_diploma());
            pnew.setImg_diploma(educacion.getImg_diploma());
            pnew.setFecha_inicio(educacion.getFecha_inicio());
            pnew.setFecha_fin(educacion.getFecha_fin());
            return "Se editó la educacion con ID:"+" "+id+" "+"corractamente.";
        }

        else { //si es nulo, no exite entonces lo creo
            // educacionController.save(educacion);
            return "No se encontró la educacion con ID:"+" "+id+".";

        }

    }
}
