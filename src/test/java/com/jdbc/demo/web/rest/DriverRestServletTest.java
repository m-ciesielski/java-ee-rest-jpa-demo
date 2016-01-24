package com.jdbc.demo.web.rest;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jdbc.demo.domain.Driver;
import com.sun.messaging.jmq.io.Status;
import org.junit.Assert;
import org.junit.Test;
import utils.TestModelsFactory;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Mateusz on 02-Jan-16.
 */
public class DriverRestServletTest {

    @Test
    public void addDriver(){
        Driver driver = TestModelsFactory.createTestDriver1(TestModelsFactory.createTestAddress1());

        Response resp = given()
                            .body(driver).contentType(ContentType.JSON)
                        .expect()
                            .contentType(ContentType.JSON).statusCode(Status.OK)
                        .when()
                            .post("localhost:8080/api/drivers");

        Driver addedDriver = resp.as(Driver.class);

        Assert.assertEquals(driver, addedDriver);
    }
}
