package com.object;

import java.util.Date;

/**
 * Created by wangqi on 16/4/5.
 */
public class FlightSearchCriteria {
    private String departFrom;
    private Date departOn;
    private String arriveAt;
    private Date returnOn;
    public Date getReturnOn() {
        return returnOn;
    }
    public void setReturnOn(Date arriveOn) {
        this.returnOn = arriveOn;
    }
    public Date getDepartOn() {
        return departOn;
    }
    public void setDepartOn(Date departOn) {
        this.departOn = departOn;
    }
    public String getArriveAt() {
        return arriveAt;
    }
    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }
    public String getDepartFrom() {
        return departFrom;
    }
    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }
}
