package ar.com.argentinaprograma.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String titulo_proyecto;
    
    @Column
    private String url_proyecto;
    
    @Column
    private String img_proyecto;
    
    @Column
    private String descripcion_proyecto;

// GETTERS & SETTERS 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo_proyecto() {
        return titulo_proyecto;
    }

    public void setTitulo_proyecto(String titulo_proyecto) {
        this.titulo_proyecto = titulo_proyecto;
    }

    public String getUrl_proyecto() {
        return url_proyecto;
    }

    public void setUrl_proyecto(String url_proyecto) {
        this.url_proyecto = url_proyecto;
    }

    public String getImg_proyecto() {
        return img_proyecto;
    }

    public void setImg_proyecto(String img_proyecto) {
        this.img_proyecto = img_proyecto;
    }

    public String getDescripcion_proyecto() {
        return descripcion_proyecto;
    }

    public void setDescripcion_proyecto(String descripcion_proyecto) {
        this.descripcion_proyecto = descripcion_proyecto;
    }

}
