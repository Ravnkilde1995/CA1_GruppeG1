package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AddressDTO;
import dtos.PersonDTO;
import entities.Address;
import entities.Person;
import facades.AddressFacade;
import facades.FacadeExample;
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

    @GET
    @Path("addresses")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersons() {
        List<Address> addresses = addressFacade.getAllAddresses();

        return Response.status(200).entity(GSON.toJson(addresses)).build();
    }

    @GET
    @Path("address/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Address getPersonById(@PathParam("id") int id) {
        Address address = addressFacade.getAddress(id);

        return address;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createPerson(String content){
        AddressDTO addressDTO = GSON.fromJson(content, AddressDTO.class);
        // Address a = addressFacade.addAddress(addressDTO.getStreet(), addressDTO.getStreetNumber(), addressDTO.getFloor(), addressDTO.getIdCityInfo());
        return Response.ok(GSON.toJson(new AddressDTO(a))).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateAddress(@PathParam("id") Integer id, String content) {
        Address a = GSON.fromJson(content, Address.class);
        a.setId(id);
        // Address returned = addressFacade.updateAddress(id);
        return Response.ok().entity(GSON.toJson(returned)).build();
    }
}
