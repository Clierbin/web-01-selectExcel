package com.kairoshijun.excel.web01selectexcel.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.constants.ResultOBJ;
import com.kairoshijun.excel.web01selectexcel.model.Channl;
import com.kairoshijun.excel.web01selectexcel.model.Finaltable;
import com.kairoshijun.excel.web01selectexcel.model.Game;
import com.kairoshijun.excel.web01selectexcel.service.*;
import com.kairoshijun.excel.web01selectexcel.time.TimeUtil;
import com.kairoshijun.excel.web01selectexcel.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName:SelectController
 * Package:com.kairoshijun.excel.web01selectexcel.controller
 * description
 *
 * @author:zhangbin
 * @date:2019/3/21
 * @Time:11:26
 * @Hello-Idea
 */
@Controller
public class SelectController {
    @Autowired
    private GameService gameService;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private FinalTableService finalTableService;
    @Autowired
    private FinaltableTwoService finaltableTwoService;
   /* @Autowired
    private ChannelAndVersionService channelAndVersionService;*/
    @RequestMapping("/index")
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
        List<Game> gameList=gameService.selectAll();
        model.addAttribute("gameList",gameList);
        //先把游戏中的中文信息保存到map中
        List<Channl> channlList=channelService.getAll();
      //  List<ChannelAndVersion> cList = channelAndVersionService.getAll();
       // List<Channl> channlList2=channelService.getAll();
        model.addAttribute("channlList",channlList);
     return "index";
    }

    @RequestMapping("/select")
    public @ResponseBody Object select(Model model,
                                       @RequestParam(value = "channelSZ[]",required = false) String[] channelSZ,
                                        @RequestParam(value = "youxiSZ[]",required = false) String[] youxiSZ
                                       ,@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime,
                                       @RequestParam(value = "flag") Integer flag) throws Exception {
      /* for (int i=0;i<selectVo.getChannelSZ().length;i++){
            System.out.println(selectVo.getChannelSZ()[i]);
        }
        for (int i=0;i<selectVo.getYouxiSZ().length;i++){
            System.out.println(selectVo.getYouxiSZ()[i]);
        }*/
        System.out.println("进入到服务器!!!");
        ResultOBJ resultOBJ = new ResultOBJ();
        if (channelSZ == null || youxiSZ == null) {
            resultOBJ.setCode(Contants.FAILURE);
            resultOBJ.setMessage("参数传递错误!");
            return resultOBJ;
        }
        List<Finaltable> flist=null;
        if (flag == 1){

            flist= finalTableService.selectByTD(channelSZ, youxiSZ, startTime, endTime);
        }else {
            flist= finaltableTwoService.selectByTD(channelSZ, youxiSZ, startTime, endTime);
        }
        if (flist==null){ resultOBJ.setCode(Contants.FAILURE);
          resultOBJ.setMessage("暂时没有查到您要查询的数据!");
          return resultOBJ;
        }
        resultOBJ.setCode(Contants.SUCCESS);
        resultOBJ.setFList(flist);

        return resultOBJ;
    }

    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response,
                      @RequestParam(value = "list",required = false) String list) throws Exception {
        System.out.println("进入到了服务器");
        //获取数据
        // List<PageData> list = reportService.bookList(page);
        //excel标题
        String[] title = {"时间", "游戏", "系列", "渠道名", "新增", "活跃", "开屏收入", "banner收入", "视频收入", "广告总收入"};
        if (list==null){
            return ;
        }
        JSONArray finaltables=JSONObject.parseArray(list);
        List<Finaltable> list1 = finaltables.toJavaList(Finaltable.class);
        //excel文件名
        String fileName = "数据Excel" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = "数据";
        String[][] content = new String[list1.size()][];
        for (int i = 0; i < list1.size(); i++) {
            content[i] = new String[title.length];
            Finaltable finaltable1 = list1.get(i);
            content[i][0] = new SimpleDateFormat("yyyy-MM-dd").format(finaltable1.getDateTime());
            content[i][1] = finaltable1.getGame();
            content[i][2] = finaltable1.getSeries();
            content[i][3] = finaltable1.getChannel();
            content[i][4] = finaltable1.getNewNumber().toString();
            content[i][5] = finaltable1.getActive().toString();
            content[i][6] = finaltable1.getSplashIncome().toString();
            content[i][7] = finaltable1.getBannerIncome().toString();
            content[i][8] = finaltable1.getVideoIncome().toString();
            content[i][9] = finaltable1.getSumIncome().toString();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
