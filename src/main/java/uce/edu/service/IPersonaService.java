package uce.edu.service;


import java.util.List;
import uce.edu.to.PersonaTo;

public interface IPersonaService {

    public PersonaTo buscarPorId(Integer id);

    public List<PersonaTo> buscarTodos();

    public  List<PersonaTo> buscarPorNombre(String nombre);

    public  List<PersonaTo> buscarPorNombreApellido(String nombre, String apellido);

    public void guardar(PersonaTo persona);
    public void actualizar(PersonaTo persona);
    public void eliminar(Integer id);
}
