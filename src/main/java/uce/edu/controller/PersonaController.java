package uce.edu.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import uce.edu.service.IPersonaService;
import uce.edu.to.PersonaTo;
@Path("/personas")
public class PersonaController {

     @Inject
    private IPersonaService iPersonaService;
    
    @GET
    @Path("/buscar")
    public Response buscarPorId( ) {
        Integer id = 1;
        
        //return this.iPersonaService.buscarPorId(id);
        return Response.ok(this.iPersonaService.buscarPorId(id)).build();
    }


    public void guardar(PersonaTo persona) {
        this.iPersonaService.guardar(persona);

    }

  
    public void actualizar(PersonaTo persona) {
        this.iPersonaService.actualizar(persona);

    }


    public void eliminar(Integer id) {
    this.iPersonaService.eliminar(id);

    }



}
