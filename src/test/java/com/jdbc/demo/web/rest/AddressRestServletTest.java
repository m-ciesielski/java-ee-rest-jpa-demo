package com.jdbc.demo.web.rest;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jdbc.demo.domain.Address;
import com.sun.messaging.jmq.io.Status;
import org.junit.Assert;
import org.junit.Test;
import utils.TestModelsFactory;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Mateusz on 17-Jan-16.
 */
public class AddressRestServletTest {

    @Test
    public void addAddress(){
        Address address = TestModelsFactory.createTestAddress1();

        Response resp = given()
                .body(address).contentType(ContentType.JSON)
                .expect()
                .contentType(ContentType.JSON).statusCode(Status.OK)
                .when()
                .post("localhost:8080/api/addresses");

        Address addedAddress = resp.as(Address.class);

        Assert.assertEquals(address, addedAddress);
    }
}
