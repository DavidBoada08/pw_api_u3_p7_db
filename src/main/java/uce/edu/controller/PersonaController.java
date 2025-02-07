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
import uce.edu.repository.modelo.Persona;
import uce.edu.service.IPersonaService;
import uce.edu.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}")

    public PersonaTo buscarPorId(@PathParam("id") Integer id) {
        // Integer id = 3;

        return this.iPersonaService.buscarPorId(id);
        // return Response.ok(this.iPersonaService.buscarPorId(id)).build();
    }

    @POST
    @Path("")
    public void guardar(PersonaTo persona) {
        this.iPersonaService.guardar(persona);

    }

    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona, @PathParam("id") Integer id) {
        // persona.setId(id);
        this.iPersonaService.actualizar(persona);

    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo persona, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        System.out.println(cedula);
        PersonaTo tmp = this.iPersonaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.iPersonaService.actualizar(tmp);

    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
        // Integer id = 3;
        this.iPersonaService.eliminar(id);

    }


    @GET
    @Path("")
    public List<PersonaTo> buscarTodos() {
        return this.iPersonaService.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    public List<PersonaTo> buscarPorNombre(
        @QueryParam("nombre") String nombre) {
        return this.iPersonaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreApellido")
    public List<PersonaTo> buscarPorNombreApellido(
        @QueryParam("nombre") String nombre,
            @QueryParam("apellido") String apellido) {
        return this.iPersonaService.buscarPorNombreApellido(nombre, apellido);
    }

}
