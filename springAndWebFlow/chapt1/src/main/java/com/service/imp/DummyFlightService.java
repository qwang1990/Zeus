package com.service.imp;

import com.object.Airport;
import com.object.Flight;
import com.object.FlightSearchCriteria;
import com.object.SpecialDeal;
import com.service.api.FlightService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by wangqi on 16/4/6.
 */
public class DummyFlightService implements FlightService {

    @Override
    public List<SpecialDeal> getSpecialDeals() {
        SpecialDeal specialDeal = new SpecialDeal(new Airport("shanghai","001"),
                new Airport("beijing","002"), BigDecimal.ONE,new Date(),new Date());
        return Arrays.asList(specialDeal);
    }

    @Override
    public List<Flight> findFlights(FlightSearchCriteria search) {
        return Arrays.asList(new Flight(),new Flight(),new Flight());
    }
}
