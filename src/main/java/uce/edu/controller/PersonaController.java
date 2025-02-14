package uce.edu.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
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
import jakarta.xml.bind.annotation.XmlRootElement;
import uce.edu.service.IPersonaService;
import uce.edu.to.PersonaTo;

@XmlRootElement
@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response buscarPorId(@PathParam("id") Integer id) {
        return Response.status(240).header("mensaje", "Persona creada pero en proceso de validacion...").header("valor1", 500) .entity(this.iPersonaService.buscarPorId(id)).build();
        //return this.iPersonaService.buscarPorId(id);
        // return Response.ok(this.iPersonaService.buscarPorId(id)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_XML)
    // solo el post no recibe PATHVARIABLE
    public void guardar(PersonaTo persona) {
        this.iPersonaService.guardar(persona);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona, @PathParam("id") Integer id) {
        persona.setId(id);
        this.iPersonaService.actualizar(persona);
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{id}")
    public Response actualizarParcial(PersonaTo persona, @PathParam("id") Integer id) {
        
        PersonaTo tmp = this.iPersonaService.buscarPorId(id);
        tmp.setNombre(persona.getNombre());
        this.iPersonaService.actualizar(tmp);
        return Response.ok(tmp).build();
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
 
        this.iPersonaService.eliminar(id);
 
    }

    @GET
    @Path("")
    public List<PersonaTo> buscarTodos() {
        return this.iPersonaService.buscarTodos();
    }
 
    @GET
    @Path("/porNombre")
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.iPersonaService.buscarPorNombre(nombre);
    }
 

    @GET
    @Path("/porNombreYApellido")
    public List<PersonaTo> buscarPorNombreApellido(@QueryParam("nombre") String nombre,@QueryParam("apellido") String apellido) {
        return this.iPersonaService.buscarPorNombreApellido(nombre, apellido);
    }
    
}