package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Game implements Serializable {
    private Integer gameid;

    private String game;

    private String series;


}