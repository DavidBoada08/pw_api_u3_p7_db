package uce.edu.service;

import java.util.List;

import uce.edu.to.EstudianteTo;

public interface IEstudianteService {

    public EstudianteTo buscarPorId(Integer id);

    public List<EstudianteTo> buscarTodos();

    public List<EstudianteTo> buscarPorNombre(String nombre);

    public List<EstudianteTo> buscarPorNombreApellido(String nombre, String apellido);

    public void guardar(EstudianteTo estudiante);

    public void actualizar(EstudianteTo estudiante);

    public void eliminar(Integer id);

}
