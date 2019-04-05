package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Huaweipay implements Serializable {
    private Date dateTime;

    private Integer gameId;

    private Double income;

}