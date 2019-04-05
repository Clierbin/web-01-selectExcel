package com.kairoshijun.excel.web01selectexcel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class Mail implements Serializable {
    private Integer id;

    private Long sendRoleId;

    private Long recvRoleId;

    private String gameId;

    private String channelId;

    private Short type;

    private String title;

    private String context;

    private Integer goodsId;

    private Integer goodsNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    private Short status;

    private String jieshou;
}
