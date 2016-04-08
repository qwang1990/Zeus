package com.controller;

import com.object.FlightSearchCriteria;
import com.service.api.FlightService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangqi on 16/4/8.
 */
public class SearchFlightsController extends SimpleFormController {
    private FlightService flights;
    public SearchFlightsController() {
        setCommandName("searchFlights");
        setCommandClass(FlightSearchCriteria.class);
        setFormView("beginSearch");
        setSuccessView("listFlights");
    }
    public void setFlightService(FlightService flights) {
        this.flights = flights;
    }
    @Override
    protected void initBinder(HttpServletRequest req,
                              ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH"), true));
    }
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        FlightSearchCriteria search = (FlightSearchCriteria) command;
        ModelAndView mav = new ModelAndView(getSuccessView());
        mav.addObject("flights", flights.findFlights(search));
        mav.addObject("searchFlights", search);
        return mav;
    }
}
