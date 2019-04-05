package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Advertisement implements Serializable {
    private Integer id;

    private Date dateTime;

    private Integer gameId;

    private Integer channlId;

    private String ad;

    private Float income;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getChannlId() {
        return channlId;
    }

    public void setChannlId(Integer channlId) {
        this.channlId = channlId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }
}