package com.jee.demo.web.routing;

import com.jee.demo.DriverDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 10-Jan-16.
 */

@WebServlet(urlPatterns = "drivers/edit/*")
public class DriverEditServlet extends HttpServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverEditServlet.class);

    @EJB
    private DriverDAO driverManager;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        LOGGER.info(String.format("Intercepted request %s",
                httpServletRequest.getServletPath()));

        long id = Long.valueOf(httpServletRequest.getPathInfo().replace("/", ""));

        if(driverManager.get(id) == null){
            LOGGER.info(String.format("Driver with id %d not found.", id));
            httpServletResponse.sendError(404, String.format("Driver with id %d not found.", id));
            return;
        }

        LOGGER.info("Redirecting to edit_driver.jsp page.");
        httpServletRequest.getRequestDispatcher("/edit_driver.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
