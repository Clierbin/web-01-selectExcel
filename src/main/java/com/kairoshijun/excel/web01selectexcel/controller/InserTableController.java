package com.kairoshijun.excel.web01selectexcel.controller;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.constants.ResultOBJ;
import com.kairoshijun.excel.web01selectexcel.service.FinalTableService;
import com.kairoshijun.excel.web01selectexcel.service.FinaltableTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

/**
 * ClassName:InserTableController
 * Package:com.kairoshijun.excel.web01selectexcel.controller
 * description
 *
 * @author:zhangbin
 * @date:2019/3/30
 * @Time:14:52
 * @Hello-Idea
 */
@RestController
public class InserTableController {
    @Autowired
    private FinalTableService finalTableService;
    @Autowired
    private FinaltableTwoService finaltableTwoService;

    @RequestMapping("/insertTable")
    public ResultOBJ insert(@RequestParam(value = "time") String time,
                            @RequestParam(value = "table") String table) {
        //判断传入参数的正确性
        String rexp = "((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$";
        boolean matches = Pattern.compile(rexp).matcher(time).matches();
        ResultOBJ resultOBJ = new ResultOBJ();
        if (matches) {
            System.out.println("正确的日期!");
            try {
                if ("table1".equals(table)) {
                    finalTableService.insertTable(time);
                    resultOBJ.setCode(Contants.SUCCESS);
                    resultOBJ.setMessage("数据插入成功");

                } else if("table2".equals(table)){
                    finaltableTwoService.insertTable(time);
                    resultOBJ.setCode(Contants.SUCCESS);
                    resultOBJ.setMessage("数据插入成功");
                }else{
                    resultOBJ.setCode(Contants.FAILURE);
                    resultOBJ.setMessage("table参数传递错误");
                }
            } catch (Exception e) {
                resultOBJ.setCode(Contants.FAILURE);
                resultOBJ.setMessage("数据添加异常");
                e.printStackTrace();
                return resultOBJ;
            }
        } else {
            System.out.println("错误的日期!");
            resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("错误的日期");
        }
        return resultOBJ;
    }
}


