package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChannelAndVersion implements Serializable {
    private Integer id;

    private String channelId;

    private String gameId;

    private Boolean isAvailable;

    private String channelInfo;

    private String versionNum;

    private String versionDownload;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(String channelInfo) {
        this.channelInfo = channelInfo;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getVersionDownload() {
        return versionDownload;
    }

    public void setVersionDownload(String versionDownload) {
        this.versionDownload = versionDownload;
    }
}