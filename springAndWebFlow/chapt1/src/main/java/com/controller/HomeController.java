package com.controller;

import com.service.api.FlightService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangqi on 16/4/5.
 */
public class HomeController extends AbstractController {
    private static final int FIVE_MINUTES = 5*60;
    private FlightService flights;
    public HomeController() {
        setSupportedMethods(new String[]{METHOD_GET});
        setCacheSeconds(FIVE_MINUTES);
    }
    public void setFlightService(FlightService flightService) {
        this.flights = flightService;
    }
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req,
                                                 HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("specials", flights.getSpecialDeals());
        return mav;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return new ModelAndView("home");
    }
}

