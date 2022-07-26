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
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String titulo_educacion;
    
    @Column
    private String localidad;
    
    @Column
    private String institucion;
    
    @Column
    private String url_diploma;
    
    @Column
    private String img_diploma;

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

    public String getTitulo_educacion() {
        return titulo_educacion;
    }

    public void setTitulo_educacion(String titulo_educacion) {
        this.titulo_educacion = titulo_educacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getUrl_diploma() {
        return url_diploma;
    }

    public void setUrl_diploma(String url_diploma) {
        this.url_diploma = url_diploma;
    }

    public String getImg_diploma() {
        return img_diploma;
    }

    public void setImg_diploma(String img_diploma) {
        this.img_diploma = img_diploma;
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

