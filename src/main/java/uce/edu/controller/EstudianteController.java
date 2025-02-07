package uce.edu.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import uce.edu.service.IEstudianteService;
import uce.edu.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService iEstudianteService;

    @GET
    @Path("/{id}")
    public EstudianteTo buscarPorId(@PathParam("id") Integer id) {
        //Integer id = 1;

        return this.iEstudianteService.buscarPorId(id);
        // return Response.ok(this.iEstudianteService.buscarPorId(id)).build();
    }

    @POST
    @Path("")
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteService.guardar(estudiante);

    }

    @PUT
    @Path("")
    public void actualizar(EstudianteTo estudiante) {
        this.iEstudianteService.actualizar(estudiante);

    }

    @PATCH
    @Path("")
    public void actualizarParcial(EstudianteTo estudiante) {
        EstudianteTo tmp = this.iEstudianteService.buscarPorId(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        this.iEstudianteService.actualizar(tmp);

    }

    @DELETE
    @Path("")
    public void borrar() {
        Integer id = 3;
        this.iEstudianteService.eliminar(id);

    }

    @GET
    @Path("")
    public List<EstudianteTo> buscarTodos() {
        return this.iEstudianteService.buscarTodos();

        //deber12 
    }

    @GET
    @Path("/porNombre")
    public List<EstudianteTo> buscarPorNombre
    (@QueryParam("nombre") String nombre) {
        return this.iEstudianteService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreApellido")
    public List<EstudianteTo> buscarPorNombreApellido(
        @QueryParam("nombre") String nombre,
        @QueryParam("apellido") String apellido) {
        return this.iEstudianteService.buscarPorNombreApellido(nombre, apellido);
    }

}
