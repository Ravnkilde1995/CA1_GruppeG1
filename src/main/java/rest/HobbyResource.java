package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HobbyDTO;
import facades.HobbyFacade;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hobby")
public class HobbyResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final HobbyFacade FACADE = HobbyFacade.getHobbyFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Velkommen til hobby siden\"}";
    }

    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getHobbyCount() {
        long count = FACADE.getHobbyCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}"; //Done manually so no need for a DTO
    }

    /*
    @GET
    @Path("hobbies")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHobbies() {
        List<Hobby> hobbies = FACADE.getAllHobbies();
        return Response.status(200).entity(GSON.toJson(hobbies)).build();
    }
    */

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getHobbyById(@PathParam("id") long id) {
        HobbyDTO hdto = FACADE.getById(id);
        hdto.setId(id);
        return GSON.toJson(hdto);
    }

    // CREATE HOBBY WITH POST
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postHobby(String input) {
        HobbyDTO hdto = GSON.fromJson(input, HobbyDTO.class);
        hdto = FACADE.createHobby(hdto);
        return Response.ok().entity(hdto).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response putHobby(@PathParam("id") long id, String input) throws Exception {
        HobbyDTO hdto = GSON.fromJson(input, HobbyDTO.class);
        System.out.println(hdto);

        System.out.println("Get the id yes: " + hdto.getId());
        hdto = FACADE.updateHobby(id, hdto);
        hdto.setId(id);
        return Response.ok().entity(hdto).build();
    }

}
