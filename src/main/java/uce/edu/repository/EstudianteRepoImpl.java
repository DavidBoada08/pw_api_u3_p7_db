package uce.edu.repository;

import java.lang.reflect.Type;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped
public class EstudianteRepoImpl  implements IEstudianteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante buscarPorId(Integer id) {

        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);

    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);

    }

    @Override
    public void eliminar(Integer id) {

        this.entityManager.remove(this.entityManager.find(Estudiante.class, id));
    }

    @Override
    public List<Estudiante> buscarTodos() {
      TypedQuery<Estudiante> mQuery = this.entityManager.
        createQuery("SELECT e FROM Estudiante e", Estudiante.class);
            return mQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombre(String nombre) {
       TypedQuery<Estudiante> mQuery = this.entityManager.
        createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre",
                Estudiante.class);
        mQuery.setParameter("nombre", nombre);
        return mQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido) {
       TypedQuery<Estudiante> mQuery = this.entityManager.
        createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre AND e.apellido = :apellido",
                Estudiante.class);
        mQuery.setParameter("nombre", nombre);
        mQuery.setParameter("apellido", apellido);
        return mQuery.getResultList();
    }

}
