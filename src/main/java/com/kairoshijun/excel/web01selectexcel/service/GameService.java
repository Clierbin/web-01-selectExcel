package com.kairoshijun.excel.web01selectexcel.service;


import com.kairoshijun.excel.web01selectexcel.model.Game;

import java.util.List;

/**
 * ClassName:GameService
 * Package:com.kairogame.select02.service
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:14:25
 * @Hello-Idea
 */
public interface GameService {
    List<Game> selectAll();
    boolean checkGameId(Integer gameId);
    boolean insertGame(Game game);
}
