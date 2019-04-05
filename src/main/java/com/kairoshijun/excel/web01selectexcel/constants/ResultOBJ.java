package com.kairoshijun.excel.web01selectexcel.constants;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kairoshijun.excel.web01selectexcel.model.Finaltable;
import com.kairoshijun.excel.web01selectexcel.model.PlayerPayLog;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:ResultOBJ
 * Package:com.kairoshijun.excel.web01selectexcel.constants
 * description
 *
 * @author:zhangbin
 * @date:2019/3/23
 * @Time:14:03
 * @Hello-Idea
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResultOBJ implements Serializable {
    private Integer code;
    private String message;
    private List<Finaltable> fList;

    private List<PlayerPayLog> pList;


}
