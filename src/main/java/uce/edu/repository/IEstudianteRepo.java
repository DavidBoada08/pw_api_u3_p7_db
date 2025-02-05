package uce.edu.repository;

import uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepo {

    public Estudiante buscarPorId(Integer id);

    public void insertar(Estudiante estudiante);

    public void actualizar(Estudiante estudiante);

    public void eliminar(Integer id);
    

}
