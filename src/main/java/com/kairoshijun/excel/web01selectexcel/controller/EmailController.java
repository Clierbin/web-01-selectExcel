package com.kairoshijun.excel.web01selectexcel.controller;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.constants.ResultOBJ;
import com.kairoshijun.excel.web01selectexcel.model.ChannelAndVersion;
import com.kairoshijun.excel.web01selectexcel.model.GameNew;
import com.kairoshijun.excel.web01selectexcel.model.Mail;
import com.kairoshijun.excel.web01selectexcel.service.ChannelAndVersionService;
import com.kairoshijun.excel.web01selectexcel.service.GameNewService;
import com.kairoshijun.excel.web01selectexcel.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:EmailController
 * Package:com.kairoshijun.excel.web01selectexcel.controller
 * description
 *
 * @author:zhangbin
 * @date:2019/4/1
 * @Time:14:47
 * @Hello-Idea
 */
@Controller
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private MailService mailService;
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
        return "mail";
    }
    @RequestMapping(value = "/insert")
    @ResponseBody
    public ResultOBJ insert(@RequestBody(required = false) Mail mail) {
        ResultOBJ resultOBJ = new ResultOBJ();
        if (mail==null){
            resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("数据添加出了个小BUG~");
            return resultOBJ;
        }
        try {

            mail.setSendRoleId((long) -1);
            mail.setStatus((short) 0);
            if (mail.getType() == 3 ) {
                mailService.insertQufu(mail);
                resultOBJ.setCode(Contants.SUCCESS);
                resultOBJ.setMessage("全服数据添加成功");
            } else {
                String[] split = mail.getJieshou().split(",");
                List<Mail> mailList = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    Mail upmail=new Mail();
                    upmail.setSendRoleId(mail.getSendRoleId());
                    upmail.setGameId(mail.getGameId());
                    upmail.setChannelId(mail.getChannelId());
                    upmail.setType(mail.getType());
                    upmail.setTitle(mail.getTitle());
                    upmail.setContext(mail.getContext());
                    upmail.setGoodsId(mail.getGoodsId());
                    upmail.setGoodsNum(mail.getGoodsNum());
                    upmail.setSendTime(mail.getSendTime());
                    upmail.setStatus(mail.getStatus());
                    upmail.setRecvRoleId(Long.valueOf(split[i]));
                    mailList.add(upmail);
                    resultOBJ.setCode(Contants.SUCCESS);
                    resultOBJ.setMessage("全服数据添加成功");
                }
                mailService.insertYiban(mailList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("数据添加出了个小BUG~");
        } finally {
            return resultOBJ;
        }
    }
}
