package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.CityInfo;
import facades.CityInfoFacade;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cityinfo")
public class CityInfoResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final CityInfoFacade cityInfoFacade =  CityInfoFacade.getCityInfoFacade(EMF);

    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCityInfoCount() {
        long count = cityInfoFacade.getCityInfoCount();
        System.out.println("Count of CityInfo is: "+count);
        return "{\"count\":"+count+"}";
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CityInfo getCityInfoById(@PathParam("id") int id) {
        CityInfo cityInfo = cityInfoFacade.getCityInfoById(id);
        System.out.println("CityInfo by ID is: "+cityInfo);
        return cityInfo;
    }

}
