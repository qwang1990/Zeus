package com.service.api;

import com.object.Flight;
import com.object.FlightSearchCriteria;
import com.object.SpecialDeal;

import java.util.List;

/**
 * Created by wangqi on 16/4/5.
 */
public interface FlightService {
    List<SpecialDeal> getSpecialDeals();
    List<Flight> findFlights(FlightSearchCriteria search);
}
