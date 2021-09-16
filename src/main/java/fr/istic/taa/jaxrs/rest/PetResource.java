package fr.istic.taa.jaxrs.rest;

import java.io.Serial;
import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.checkerframework.checker.units.qual.K;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.dao.generic.PetDao;
import fr.istic.taa.jaxrs.domain.Pet;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class PetResource {

  @GET
  @Path("/add/{name}")
  public Pet addPet(@PathParam("name") String name)  {
    Pet pet = new Pet();
    pet.setName(name);
    PetDao<Long,Pet> pdao = new PetDao<Long,Pet>();
    pdao.setClazz(Pet.class);
    pdao.save(pet);
    
      // return pet
      return new Pet();
  }

  @GET
  @Path("/{petId}")
  public Pet getPetById(@PathParam("petId") Long petId)  {

    PetDao<Long,Pet> pdao = new PetDao<Long,Pet>();
    pdao.setClazz(Pet.class);
      // return pet
      return pdao.findOne(petId);
  }

  @POST
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
    // add pet
    return Response.ok().entity("SUCCESS").build();
  }
}