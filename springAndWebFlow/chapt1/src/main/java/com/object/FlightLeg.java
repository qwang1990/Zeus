package com.object;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by wangqi on 16/4/5.
 */
public class FlightLeg {
    private Airport departFrom;
    private Date departOn;
    private Airport arriveAt;
    private Date arriveOn;
    public FlightLeg(Airport departFrom, Date departOn, Airport arriveAt,
                     Date arriveOn) {
        this.arriveAt = arriveAt;
        this.arriveOn = arriveOn;
        this.departFrom = departFrom;
        this.departOn = departOn;
    }

    public FlightLeg() {
        departFrom = new Airport("beijing","1");
        arriveAt = new Airport("shanghai","2");
        departOn = new Date();
        arriveOn = new Date();
    }

    public Airport getArriveAt() {
        return arriveAt;
    }
    public Date getArriveOn() {
        return arriveOn;
    }
    public Date getDepartOn() {
        return departOn;
    }
    public Airport getDepartFrom() {
        return departFrom;
    } }
