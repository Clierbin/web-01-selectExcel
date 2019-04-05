package com.kairoshijun.excel.web01selectexcel.controller;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.constants.ResultOBJ;
import com.kairoshijun.excel.web01selectexcel.model.ChannelAndVersion;
import com.kairoshijun.excel.web01selectexcel.model.GameNew;
import com.kairoshijun.excel.web01selectexcel.model.GameNotify;
import com.kairoshijun.excel.web01selectexcel.service.ChannelAndVersionService;
import com.kairoshijun.excel.web01selectexcel.service.GameNewService;
import com.kairoshijun.excel.web01selectexcel.service.GameNotifyService;
import com.kairoshijun.excel.web01selectexcel.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ClassName:GameNotifyController
 * Package:com.kairoshijun.excel.web01selectexcel.controller
 * description
 *
 * @author:zhangbin
 * @date:2019/4/2
 * @Time:15:12
 * @Hello-Idea
 */
@Controller
@RequestMapping("/gameNotify")
public class GameNotifyController {
    @Autowired
    private GameNotifyService gameNotifyService;
    @Autowired
    private GameNewService gameNewService;
    @Autowired
    private ChannelAndVersionService channelAndVersionService;
    @RequestMapping("/index")
    public String index(Model model){
        List<GameNew> gameNewList = gameNewService.selectAll();
        List<ChannelAndVersion> channelAndVersionList = channelAndVersionService.getAll();
        model.addAttribute("gameNewList",gameNewList);
        model.addAttribute("channelAndVersionList",channelAndVersionList);
        return "gamenotify";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public ResultOBJ insert(@RequestBody(required = false)GameNotify gameNotify){
        ResultOBJ resultOBJ=new ResultOBJ();
        //if (gameNotify==null) gameNotify=new GameNotify();
        if (gameNotify==null){
            resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("数据添加出了个小BUG~");
            return resultOBJ;
        }
        gameNotify.setUpdateTime(TimeUtil.getTime());
        gameNotify.setCreateTime(TimeUtil.getTime());
        try {
            gameNotifyService.insert(gameNotify);
            resultOBJ.setCode(Contants.SUCCESS);
            resultOBJ.setMessage("数据添加成功!");
        }catch (Exception e){
            resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("数据添加出了个小BUG~");
            e.printStackTrace();
        }finally {
        return resultOBJ;
        }
    }
}
