package com.jee.demo;

import com.jee.demo.domain.Driver;

import java.util.List;

public interface DriverDAO {
    List<Driver> getAll();
    Driver add(Driver driver);
    Driver get(long id);
    Driver update(Driver driver);
    void delete(long id);
    void delete(Driver driver);
}
