package com.jee.demo;

import com.jee.demo.domain.FreightTransport;

import java.util.List;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public interface FreightTransportDAO {
    List<FreightTransport> getAll();
    FreightTransport add(FreightTransport freightTransport);
    FreightTransport update(FreightTransport freightTransport);
    void delete(long id);
    void delete(FreightTransport freightTransport);
    FreightTransport get(long id);
}
