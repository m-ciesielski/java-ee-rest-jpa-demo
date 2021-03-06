package com.jee.demo.web.rest;

import com.jee.demo.DriverDAO;
import com.jee.demo.domain.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Mateusz on 07-Dec-15.
 */

@Path("drivers")
@Stateless
public class DriverRestServlet {
    private final static Logger LOGGER = LoggerFactory.getLogger(DriverRestServlet.class);

    @EJB
    private DriverDAO driverManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Driver> getDrivers() {
        return driverManager.getAll();
    }

    @POST
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    public Driver addDriver(Driver driver) {

        LOGGER.info(String.format("Adding driver %s.", driver));
        return driverManager.add(driver);
    }

    @Path("/{id}")
    @GET
    @Produces("application/json; charset=UTF-8")
    public Driver getDriver(@PathParam("id") int id) {
        return driverManager.get(id);
    }

    @Path("/{id}")
    @POST
    @Consumes("application/json; charset=UTF-8")
    public void updateDriver(Driver driver) {
        LOGGER.info(String.format("Updating driver %s.", driver));
        driverManager.update(driver);
    }

    @Path("/{id}")
    @DELETE
    public void deleteDriver(@PathParam("id") int id) {

        Driver driver = driverManager.get(id);
        LOGGER.info(String.format("Deleting driver %s.", driver));
        driverManager.delete(id);
    }
}
