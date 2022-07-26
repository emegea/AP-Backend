package ar.com.argentinaprograma.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String acerca_de;
    @Column
    private String apellido;
    @Column
    private String ciudad;
    @Column
    private String email;
    @Temporal (TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")    
    @Column
    private Date fecha_nac;
    @Column
    private String nombre;
    @Column
    private String nombre_usuario;
    @Column
    private String pais;
    @Column
    private String password;
    @Column
    private String provincia;
    @Column
    private String puesto;
    @Column
    private String telefono;
    @Column
    private String url_img;

// RELACIONES    
 
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<Experiencia> experiencia;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<Habilidad> habilidad;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<Proyecto> proyecto;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<Educacion> educacion;
    
// GETTERS & SETTERS 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public List<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

    public List<Habilidad> getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(List<Habilidad> habilidad) {
        this.habilidad = habilidad;
    }

    public List<Proyecto> getProyecto() {
        return proyecto;
    }

    public void setProyecto(List<Proyecto> proyecto) {
        this.proyecto = proyecto;
    }

    public List<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<Educacion> educacion) {
        this.educacion = educacion;
    }

}