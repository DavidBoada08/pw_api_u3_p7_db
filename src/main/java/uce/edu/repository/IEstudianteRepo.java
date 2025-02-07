package uce.edu.repository;

import java.util.List;

import uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepo {

    public Estudiante buscarPorId(Integer id);

    public List<Estudiante> buscarTodos();
    
    public List<Estudiante> buscarPorNombre(String nombre);

    public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido);

    public void insertar(Estudiante estudiante);

    public void actualizar(Estudiante estudiante);

    public void eliminar(Integer id);
    

}
