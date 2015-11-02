package com.jdbc.demo;

import com.jdbc.demo.domain.Vehicle;
import com.jdbc.demo.services.VehicleEntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by mciesielski on 2015-10-23.
 */
public class VehicleEntityManagerTest {

    private VehicleEntityManager vehicleEntityManager;
    private ArrayList<Vehicle> testVehicles = new ArrayList<Vehicle>();

    @Before
    public void setUp() throws Exception {
        vehicleEntityManager = new VehicleEntityManager();
    }

    @After
    public void tearDown() throws Exception {
        for (Vehicle testVehicle: testVehicles){
            vehicleEntityManager.delete(testVehicle);
        }

    }

    @Test
    public void getAllTest() throws Exception {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Scania");
        vehicle1.setEngine(16);
        vehicle1.setHorsepower(300);
        vehicle1.setType("ZX-83");
        vehicle1.setVIN("1M8GDM9A_KP042777");
        vehicle1.setProductionDate(new Date(System.currentTimeMillis()));
        vehicleEntityManager.add(vehicle1);
        testVehicles.add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setBrand("Scania");
        vehicle2.setEngine(16);
        vehicle2.setHorsepower(300);
        vehicle2.setType("ZX-83");
        vehicle2.setVIN("1M8GDM9A_KE042777");
        vehicle2.setProductionDate(new Date(System.currentTimeMillis()));
        vehicleEntityManager.add(vehicle2);
        testVehicles.add(vehicle2);

        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle1));
        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle2));
    }

    @Test
    public void deleteTest() throws Exception {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Scania");
        vehicle1.setEngine(16);
        vehicle1.setHorsepower(300);
        vehicle1.setType("ZX-83");
        vehicle1.setVIN("1M8GDM9A_KP042777");
        vehicle1.setProductionDate(new Date(System.currentTimeMillis()));
        vehicleEntityManager.add(vehicle1);
        testVehicles.add(vehicle1);

        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle1));

        vehicleEntityManager.delete(vehicle1);

        Assert.assertFalse(vehicleEntityManager.getAll().contains(vehicle1));
    }

    @Test
    public void addTest() throws Exception {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Scania");
        vehicle1.setEngine(16);
        vehicle1.setHorsepower(300);
        vehicle1.setType("ZX-83");
        vehicle1.setVIN("1M8GDM9A_KP042777");
        vehicle1.setProductionDate(new Date(System.currentTimeMillis()));
        vehicleEntityManager.add(vehicle1);
        testVehicles.add(vehicle1);
        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle1));
    }

    @Test
    public void getByIdTest() throws Exception {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setBrand("Scania");
        vehicle1.setEngine(16);
        vehicle1.setHorsepower(300);
        vehicle1.setType("ZX-83");
        vehicle1.setVIN("1M8GDM9A_KP042777");
        vehicle1.setProductionDate(new Date(System.currentTimeMillis()));
        vehicleEntityManager.add(vehicle1);
        testVehicles.add(vehicle1);

        Assert.assertTrue(vehicleEntityManager.getAll().contains(vehicle1));

        Vehicle foundVehicle1 = vehicleEntityManager.get(vehicle1.getId());

        Assert.assertEquals(vehicle1, foundVehicle1);
    }
}