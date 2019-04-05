package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Channl implements Serializable {
    private Integer channelid;

    private String channel;

    public Integer getChannelid() {
        return channelid;
    }

    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}