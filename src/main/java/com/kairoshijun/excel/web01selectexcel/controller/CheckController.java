package com.kairoshijun.excel.web01selectexcel.controller;

import com.kairoshijun.excel.web01selectexcel.model.Channl;
import com.kairoshijun.excel.web01selectexcel.model.Game;
import com.kairoshijun.excel.web01selectexcel.service.ChannelService;
import com.kairoshijun.excel.web01selectexcel.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:CheckController
 * Package:com.kairoshijun.excel.web01selectexcel.controller
 * description
 *
 * @author:zhangbin
 * @date:2019/3/27
 * @Time:10:43  Cannot resolve symbol verified
 * @Hello-Idea
 */
@RestController
public class CheckController {
    @Autowired
    private GameService gameService;
    @Autowired
    private ChannelService channelService;
    @RequestMapping("/checkGameId")
    public boolean checkGameId(@RequestParam(value = "gameId",required = true) Integer gameId){
        return gameService.checkGameId(gameId);
    }
    @RequestMapping("/insertGame")
    public boolean insertGame(@RequestParam(value = "gameId",required = true) Integer gameId,
                              @RequestParam(value = "gameName",required = true) String gameName,
                              @RequestParam(value = "gameSeries",required = true) String gameSeries){
        Game game=new Game();
        game.setGameid(gameId);
        game.setGame(gameName);
        game.setSeries(gameSeries);
        return gameService.insertGame(game);
    }
    @RequestMapping("/checkChannelId")
    public boolean checkChannelId(@RequestParam(value = "channelId",required = true) Integer channelId){
        return channelService.checkChannelId(channelId);
    }
    @RequestMapping("/insertChannel")
    public boolean insertChannel(@RequestParam(value = "channelId",required = true) Integer channelId,
                              @RequestParam(value = "ChannelName",required = true) String ChannelName){

        Channl channl=new Channl();
        channl.setChannelid(channelId);
        channl.setChannel(ChannelName);
        return channelService.insertChannel(channl);
    }
}
