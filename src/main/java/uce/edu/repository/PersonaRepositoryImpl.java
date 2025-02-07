package uce.edu.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.repository.modelo.*;

@Transactional
@ApplicationScoped
public class PersonaRepositoryImpl implements IPersonaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Persona buscarPorId(Integer id) {

        return this.entityManager.find(Persona.class, id);
    }

    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);

    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);

    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.entityManager.find(Persona.class, id));

    }

    @Override
    public List<Persona> buscarTodos() {
        TypedQuery<Persona> mQuery = this.entityManager.
        createQuery("SELECT p FROM Persona p", Persona.class);
        return mQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {

        TypedQuery<Persona> mQuery = this.entityManager.
        createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre",
                Persona.class);
        mQuery.setParameter("nombre", nombre);
        return mQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
        TypedQuery<Persona> mQuery = this.entityManager.
        createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre AND p.apellido = :apellido",
                Persona.class);
        mQuery.setParameter("nombre", nombre);
        mQuery.setParameter("apellido", apellido);
        return mQuery.getResultList();
    }

}