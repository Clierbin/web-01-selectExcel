package com.kairoshijun.excel.web01selectexcel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GiftCode implements Serializable {
    private Integer id;

    private String giftCode;

    private Integer giftListId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }

    public Integer getGiftListId() {
        return giftListId;
    }

    public void setGiftListId(Integer giftListId) {
        this.giftListId = giftListId;
    }
}