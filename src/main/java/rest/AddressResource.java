package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AddressDTO;
import dtos.PersonDTO;
import entities.Address;
import entities.Person;
import facades.AddressFacade;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("address")
public class AddressResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final AddressFacade addressFacade =  AddressFacade.getAddressFacade(EMF);
    private static final PersonFacade personFacade =  PersonFacade.getPersonFacade(EMF);


    @GET
    @Path("address/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Address getPersonById(@PathParam("id") int id) {
        Address address = addressFacade.getAddress(id);

        return address;
    }

    /*
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createAddress(String content){
        Address address = GSON.fromJson(content, Address.class);
        Address returned = addressFacade.addAddress(address);

        return Response.ok().entity(GSON.toJson(returned)).build();
    }

     */

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteAddress(@PathParam("id") Integer id) {
        Address returned = addressFacade.deleteAddress(id);

        return Response.ok().entity(GSON.toJson(returned)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateAddress(@PathParam("id") Integer id, String content) {
        Person pd = GSON.fromJson(content, Person.class);
        pd.setId(id);
        Address returned = addressFacade.updateAddress(id);

        return Response.ok().entity(GSON.toJson(returned)).build();
    }

}
