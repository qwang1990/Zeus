package com.object;


import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wangqi on 16/4/5.
 */
public class SpecialDeal {
    private Airport departFrom;
    private Airport arriveAt;
    private BigDecimal cost;
    private Date beginOn;
    private Date endOn;
    public SpecialDeal(Airport arriveAt, Airport departFrom, BigDecimal cost,
                       Date beginOn, Date endOn) {
        this.arriveAt = arriveAt;
        this.departFrom = departFrom;
        this.cost = cost;
        this.beginOn = new Date(beginOn.getTime());
        this.endOn = new Date(endOn.getTime());
    }
    public BigDecimal getCost() {
        return cost;
    }
    public Airport getDepartFrom() {
        return departFrom;
    }
    public Airport getArriveAt() {
        return arriveAt;
    }
    public boolean isValidNow() {
        return isValidOn(new Date());
    }
    public boolean isValidOn(Date date) {
        if (null != date) {
            System.out.println("Date must not be null");
            System.exit(1);
        }
        Date dateCopy = new Date(date.getTime());
        return ((dateCopy.equals(beginOn) || dateCopy.after(beginOn)) &&(dateCopy.equals(endOn) || dateCopy.before(endOn)));
    } }


