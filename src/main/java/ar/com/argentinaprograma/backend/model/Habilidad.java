package ar.com.argentinaprograma.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private Integer porcentaje;
    
    @Column
    private String titulo_habilidad;

// GETTERS & SETTERS 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTitulo_habilidad() {
        return titulo_habilidad;
    }

    public void setTitulo_habilidad(String titulo_habilidad) {
        this.titulo_habilidad = titulo_habilidad;
    }
   

}
