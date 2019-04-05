package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.util.Date;
@Data
public class LipinmaList {
    private Integer id;

    private String gameId;

    private String channelId;

    private Integer type;

    private String lpName;

    private String descTxt;

    private String lpRewardId;

    private Integer lpNum;

    private String beginTime;

    private String endTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLpName() {
        return lpName;
    }

    public void setLpName(String lpName) {
        this.lpName = lpName;
    }

    public String getDescTxt() {
        return descTxt;
    }

    public void setDescTxt(String descTxt) {
        this.descTxt = descTxt;
    }

    public String getLpRewardId() {
        return lpRewardId;
    }

    public void setLpRewardId(String lpRewardId) {
        this.lpRewardId = lpRewardId;
    }

    public Integer getLpNum() {
        return lpNum;
    }

    public void setLpNum(Integer lpNum) {
        this.lpNum = lpNum;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}