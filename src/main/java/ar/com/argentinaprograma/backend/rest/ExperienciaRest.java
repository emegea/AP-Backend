package ar.com.argentinaprograma.backend.rest;

import ar.com.argentinaprograma.backend.controller.ExperienciaController;
import ar.com.argentinaprograma.backend.model.Experiencia;
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
@RequestMapping("api/experiencia")
@CrossOrigin (origins = "https://portfolio-argentina-prog-e585f.web.app")
public class ExperienciaRest {

    @Autowired
    private ExperienciaController experienciaController;
// VER TODOS
    @GetMapping("/listar")
    public List<Experiencia> listar(){
        return experienciaController.findAll();
    } 
//GUARDAR
@PostMapping("/nueva")
    public Experiencia saveExperiencia(@RequestBody Experiencia experiencia){
        return experienciaController.save(experiencia);
    }
//BUSCAR POR ID
    @GetMapping("/{id}")
    public Optional<Experiencia> findById(@PathVariable("id") Long id){
        return experienciaController.findById(id);
    }
//BORRAR POR ID
    @DeleteMapping("/borrar/{id}")
    public String deleteById(@PathVariable("id") Long id){
        experienciaController.deleteById(id);
        return "Se eliminó la experiencia con ID:"+" "+id+" "+"corractamente.";
    }

//EDITAR
    @PutMapping("/editar/{id}")
    public String editarExperiencia(@PathVariable("id") Long id, @RequestBody Experiencia experiencia) {
        Experiencia pnew=experienciaController.findById(id).orElse(null);
        //pregunto si no es nulo, entonces edito el existente
        if(pnew!=null){
            pnew.setNombre_empresa(experiencia.getNombre_empresa());
            pnew.setLocalidad_empresa(experiencia.getLocalidad_empresa());
            pnew.setUrl_empresa(experiencia.getUrl_empresa());
            pnew.setImg_empresa(experiencia.getImg_empresa());
            pnew.setPuesto(experiencia.getPuesto());
            pnew.setFecha_inicio(experiencia.getFecha_inicio());
            pnew.setFecha_fin(experiencia.getFecha_fin());
            experienciaController.save(pnew);
            return "Se editó la experiencia con ID:"+" "+id+" "+"corractamente.";
        }

        else { //si es nulo, no exite entonces lo creo
            // experienciaController.save(experiencia);
            return "No se encontró la experiencia con ID:"+" "+id+".";

        }

    }
}
