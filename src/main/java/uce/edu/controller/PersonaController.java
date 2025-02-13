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
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.service.IPersonaService;
import uce.edu.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response buscarPorId(@PathParam("id") Integer id) {
        return Response.status(240).header("mensaje", "Persona creada en proceso de validacion...")
                .entity(this.iPersonaService.buscarPorId(id)).build();
    }

    @POST
    @Path("")
    public Response guardar(PersonaTo persona) {
        this.iPersonaService.guardar(persona);
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(PersonaTo persona, @PathParam("id") Integer id) {
        this.iPersonaService.actualizar(persona);
        return Response.status(200).build();
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public Response actualizarParcial(PersonaTo persona, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        PersonaTo tmp = this.iPersonaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.iPersonaService.actualizar(tmp);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response borrar(@PathParam("id") Integer id) {
        this.iPersonaService.eliminar(id);
        return Response.status(204).build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_XML)
    public List<PersonaTo> buscarTodos() {
        return this.iPersonaService.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    @Produces(MediaType.APPLICATION_XML)
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.iPersonaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porNombreApellido")
    @Produces(MediaType.APPLICATION_XML)
    public List<PersonaTo> buscarPorNombreApellido(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido) {
        return this.iPersonaService.buscarPorNombreApellido(nombre, apellido);
    }
}