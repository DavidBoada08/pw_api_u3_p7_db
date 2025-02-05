package uce.edu.service;

import uce.edu.to.EstudianteTo;

public interface IEstudianteService {

    EstudianteTo buscarPorId(Integer id);

    void guardar(EstudianteTo estudiante);

    void actualizar(EstudianteTo estudiante);

    void eliminar(Integer id);

}
