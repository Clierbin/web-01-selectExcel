package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PlayerPayLog implements Serializable {
    private Integer id;

    private Long roleId;

    private String gameId;
    private String gameName;

    private String channelId;
    private String channelName;

    private String goodsName;

    private Date createTime;

    private Float rmb;

    private Integer currencyGet;

    private Integer currencyGetExtra;

    private String orderId;

    private Integer payStatus;

    private String iosStatus;

    private String iosVerify;

    private String iosReceipt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getRmb() {
        return rmb;
    }

    public void setRmb(Float rmb) {
        this.rmb = rmb;
    }

    public Integer getCurrencyGet() {
        return currencyGet;
    }

    public void setCurrencyGet(Integer currencyGet) {
        this.currencyGet = currencyGet;
    }

    public Integer getCurrencyGetExtra() {
        return currencyGetExtra;
    }

    public void setCurrencyGetExtra(Integer currencyGetExtra) {
        this.currencyGetExtra = currencyGetExtra;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getIosStatus() {
        return iosStatus;
    }

    public void setIosStatus(String iosStatus) {
        this.iosStatus = iosStatus;
    }

    public String getIosVerify() {
        return iosVerify;
    }

    public void setIosVerify(String iosVerify) {
        this.iosVerify = iosVerify;
    }

    public String getIosReceipt() {
        return iosReceipt;
    }

    public void setIosReceipt(String iosReceipt) {
        this.iosReceipt = iosReceipt;
    }
}