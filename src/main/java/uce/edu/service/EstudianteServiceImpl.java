package uce.edu.service;

import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.repository.IEstudianteRepo;
import uce.edu.repository.modelo.Estudiante;
import uce.edu.to.EstudianteTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    private Function<Estudiante,EstudianteTo> mapTo = e -> {
        EstudianteTo eTo = new EstudianteTo(
            e.getId(), 
            e.getNombre(), 
            e.getApellido(), 
            e.getFechaNacimiento(),
            e.getCedula(),
            e.getHobbie());
        return eTo;
    };
    
    private Function<EstudianteTo,Estudiante> mapEstudiante = eTo -> {
        Estudiante e = new Estudiante(
            eTo.getId(), 
            eTo.getNombre(), 
            eTo.getApellido(), 
            eTo.getFechaNacimiento(),
            eTo.getCedula(),
            eTo.getHobbie());
        return e;
    };


    @Inject
    private IEstudianteRepo iEstudianteRepo;

    @Override
    public EstudianteTo buscarPorId(Integer id) {
        return this.mapTo.apply(this.iEstudianteRepo.buscarPorId(id));
    }

    @Override
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteRepo.insertar(this.mapEstudiante.apply(estudiante));

    }

    @Override
    public void actualizar(EstudianteTo estudiante) {
        Estudiante e = this.mapEstudiante.apply(estudiante);
        this.iEstudianteRepo.actualizar(e);

    }

    @Override
    public void eliminar(Integer id) {
        this.iEstudianteRepo.eliminar(id);

    }

}
