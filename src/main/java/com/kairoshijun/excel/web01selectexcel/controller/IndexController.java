package com.kairoshijun.excel.web01selectexcel.controller;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.constants.ResultOBJ;
import com.kairoshijun.excel.web01selectexcel.model.GameNew;
import com.kairoshijun.excel.web01selectexcel.model.PlayerPayLog;
import com.kairoshijun.excel.web01selectexcel.service.GameNewService;
import com.kairoshijun.excel.web01selectexcel.service.PlayerPayLogService;
import com.kairoshijun.excel.web01selectexcel.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName:IndexController
 * Package:com.kairogame.select02.controller
 * description this class is make to select data
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:14:21
 * @Hello-Idea
 */
@Controller
public class IndexController {
    @Autowired
    private GameNewService gameNewService;
    @Autowired
    PlayerPayLogService playerPayLogService;

    private List<GameNew> gameNewList;

    @RequestMapping("/index2")
    public String index(Model model){
        //获取昨天的时间
        String ZUOTIAN= TimeUtil.getYesterdayString();
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        //转换提日期输出格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String str =simpleDateFormat.format(date);
        model.addAttribute("timez",ZUOTIAN);
        model.addAttribute("timej",str);
        //游戏List
        gameNewList=gameNewService.selectAll();
        model.addAttribute("gameList",gameNewList);
        return "index2";
    }
    @RequestMapping("/select2")
    public @ResponseBody
    ResultOBJ select(Model model,
                     @RequestParam(value = "youxiSZ[]",required = false) Integer[] youxiSZ
            , @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime) throws Exception {
      /* for (int i=0;i<selectVo.getChannelSZ().length;i++){
            System.out.println(selectVo.getChannelSZ()[i]);
        }
        for (int i=0;i<selectVo.getYouxiSZ().length;i++){
            System.out.println(selectVo.getYouxiSZ()[i]);
        }*/
        System.out.println("进入到服务器!!!");
        ResultOBJ resultOBJ = new ResultOBJ();
        if (youxiSZ == null) {
            resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("参数传递错误!");
            return resultOBJ;
        }
        List<PlayerPayLog> plist=playerPayLogService.selectByTD(10000,youxiSZ,startTime,endTime);
        Iterator<PlayerPayLog> iterator = plist.iterator();
        Map<String,String > map=new HashMap<>();
        Iterator<GameNew> iterator1 = gameNewList.iterator();
        while (iterator1.hasNext()){
            GameNew next = iterator1.next();
            map.put(next.getGameId(),next.getNameCn());
        }
        for (PlayerPayLog p : plist){
          p.setGameName(map.get(p.getGameId()));
        }
        if (plist==null){ resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("暂时没有查到您要查询的数据!");
            return resultOBJ;
        }
        resultOBJ.setCode(Contants.SUCCESS);
        resultOBJ.setPList(plist);
        return resultOBJ;
    }
}
