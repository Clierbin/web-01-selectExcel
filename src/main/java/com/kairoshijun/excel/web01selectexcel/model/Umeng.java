package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Umeng implements Serializable {
    private Integer id;

    private Integer gameid;

    private Date datetime;

    private Integer channlid;

    private Integer xinzeng;

    private Integer huoyue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getChannlid() {
        return channlid;
    }

    public void setChannlid(Integer channlid) {
        this.channlid = channlid;
    }

    public Integer getXinzeng() {
        return xinzeng;
    }

    public void setXinzeng(Integer xinzeng) {
        this.xinzeng = xinzeng;
    }

    public Integer getHuoyue() {
        return huoyue;
    }

    public void setHuoyue(Integer huoyue) {
        this.huoyue = huoyue;
    }
}