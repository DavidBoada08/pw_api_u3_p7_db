package uce.edu.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.redissi.moshi.adapter.iso8601.jdk8.LocalDateTimeAdapter;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



public class EstudianteTo implements Serializable{

  

    private Integer id;
    private String nombre;
    private String apellido;
  
    private LocalDateTime fechaNacimiento;
    private String cedula;
    private String hobbie;

    public EstudianteTo() {
    }
    
    public EstudianteTo(Integer id, String nombre, String apellido, LocalDateTime fechaNacimiento, String cedula, String hobbie) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.hobbie = hobbie;
    }

       // Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

 
   




}
