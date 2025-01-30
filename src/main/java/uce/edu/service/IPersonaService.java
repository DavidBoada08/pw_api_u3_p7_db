package uce.edu.service;


import uce.edu.to.PersonaTo;

public interface IPersonaService {

    public PersonaTo buscarPorId(Integer id);
    public void guardar(PersonaTo persona);
    public void actualizar(PersonaTo persona);
    public void eliminar(Integer id);
}
