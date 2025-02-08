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
        return this.iEstudianteService.buscarPorId(id);
    }

    @POST
    @Path("")
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteService.guardar(estudiante);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(EstudianteTo estudiante, @PathParam("id") Integer id) {
        estudiante.setId(id);
        this.iEstudianteService.actualizar(estudiante);
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(EstudianteTo estudiante, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        System.out.println(cedula);
        EstudianteTo tmp = this.iEstudianteService.buscarPorId(id);
        tmp.setNombre(estudiante.getNombre());
        tmp.setCedula(cedula); // Asegúrate de que este método exista en EstudianteTo
        this.iEstudianteService.actualizar(tmp);
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
        this.iEstudianteService.eliminar(id);
    }

    @GET
    @Path("")
    public List<EstudianteTo> buscarTodos() {
        return this.iEstudianteService.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    public List<EstudianteTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.iEstudianteService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreApellido")
    public List<EstudianteTo> buscarPorNombreApellido(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido) {
        return this.iEstudianteService.buscarPorNombreApellido(nombre, apellido);
    }
}