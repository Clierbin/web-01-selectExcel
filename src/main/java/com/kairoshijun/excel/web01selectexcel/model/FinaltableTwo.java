package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class FinaltableTwo implements Serializable {
    private Integer id;

    private String game;

    private String series;

    private String channel;

    private Date dateTime;

    private Double splashIncome;

    private Double bannerIncome;

    private Double videoIncome;

    private Double ngIncome;

    private Double sumIncome;

    private Integer newNumber;

    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Double getSplashIncome() {
        return splashIncome;
    }

    public void setSplashIncome(Double splashIncome) {
        this.splashIncome = splashIncome;
    }

    public Double getBannerIncome() {
        return bannerIncome;
    }

    public void setBannerIncome(Double bannerIncome) {
        this.bannerIncome = bannerIncome;
    }

    public Double getVideoIncome() {
        return videoIncome;
    }

    public void setVideoIncome(Double videoIncome) {
        this.videoIncome = videoIncome;
    }

    public Double getSumIncome() {
        return sumIncome;
    }

    public void setSumIncome(Double sumIncome) {
        this.sumIncome = sumIncome;
    }

    public Integer getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(Integer newNumber) {
        this.newNumber = newNumber;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}