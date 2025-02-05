package uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(name = "est_id")
    @GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
    private Integer id;

    @Column(name = "est_nombre")
    private String nombre;

    @Column(name = "est_apellido")
    private String apellido;

    @Column(name = "est_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    @Column(name = "est_cedula")
    private String cedula;

    @Column(name= "est_hobbie")
    private String hobbie;

    //contructore
    public Estudiante() {
    }

    public Estudiante(Integer id, String nombre, String apellido, LocalDateTime fechaNacimiento, String cedula, String hobbie) {
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
