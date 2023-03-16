package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final FacadeExample FACADE = FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final PersonFacade personFacade = PersonFacade.getPersonFacade(EMF);
    private static final AddressFacade addressFacade = AddressFacade.getAddressFacade(EMF);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Velkommen til vores single page\"}";
    }

    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {

        long count = FACADE.getRenameMeCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO

    }


    // Creates person with address and city info

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("createPersonAddressCity")
    public Response createPerson(PersonDTO personDTO) {

        Address address = addressFacade.addAddress(personDTO.getStreet(), personDTO.getStreetNumber(), personDTO.getFloor(), personDTO.getIdCityInfo());
        Person person = personFacade.addPerson(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getEmail(), personDTO.getPhoneNumber(), address);

        return Response.ok().entity(GSON.toJson(person)).build();
    }
}
