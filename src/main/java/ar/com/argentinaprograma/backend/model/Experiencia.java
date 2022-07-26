package ar.com.argentinaprograma.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nombre_empresa;
    
    @Column
    private String localidad_empresa;
    
    @Column
    private String url_empresa;
    
    @Column
    private String img_empresa;
    
    @Column
    private String puesto;

    @Temporal (TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")    
    @Column
    private Date fecha_inicio; 
    
    @Temporal (TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")    
    @Column
    private Date fecha_fin;

// GETTERS & SETTERS 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getLocalidad_empresa() {
        return localidad_empresa;
    }

    public void setLocalidad_empresa(String localidad_empresa) {
        this.localidad_empresa = localidad_empresa;
    }

    public String getUrl_empresa() {
        return url_empresa;
    }

    public void setUrl_empresa(String url_empresa) {
        this.url_empresa = url_empresa;
    }

    public String getImg_empresa() {
        return img_empresa;
    }

    public void setImg_empresa(String img_empresa) {
        this.img_empresa = img_empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

  
}