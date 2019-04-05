package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

@Data
public class Lipinma {
    private Integer id;

    private String lipinma;

    private Integer lpListId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLipinma() {
        return lipinma;
    }

    public void setLipinma(String lipinma) {
        this.lipinma = lipinma;
    }

    public Integer getLpListId() {
        return lpListId;
    }

    public void setLpListId(Integer lpListId) {
        this.lpListId = lpListId;
    }
}