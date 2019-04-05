package com.kairoshijun.excel.web01selectexcel.controller;

import com.alibaba.fastjson.JSONObject;
import com.kairoshijun.excel.web01selectexcel.model.*;
import com.kairoshijun.excel.web01selectexcel.service.ChannelAndVersionService;
import com.kairoshijun.excel.web01selectexcel.service.GameNewService;
import com.kairoshijun.excel.web01selectexcel.service.GiftCodeService;
import com.kairoshijun.excel.web01selectexcel.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName:LipinmaController
 * Package:com.kairoshijun.excel.web01selectexcel.controller
 * description
 *
 * @author:zhangbin
 * @date:2019/4/2
 * @Time:15:48
 * @Hello-Idea
 */
@Controller
@RequestMapping("/lipinma")
public class LipinmaController {

    @Autowired
    private GiftCodeService giftCodeService;
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
        return "giftcode";
    }
    @RequestMapping("/insert")
    public
    void insert(HttpServletResponse response, @RequestParam(required = false)String giftCodeList) throws IOException {//responce 流  返回excel下载  礼品码的个数必须大于0

        if (giftCodeList==null) {//返回异常
            response.getWriter().println("404.hehehe!!!");
            return;
        }
        GiftCodeList giftCodeList1 = JSONObject.parseObject(giftCodeList, GiftCodeList.class);
        try {
            SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sDateFormat.format(new Date());
            giftCodeList1.setCreateTime(sDateFormat.parse(format));
            List<GiftCode> giftCodes=  giftCodeService.insert(giftCodeList1);
            String[] title = {"id", "礼品码", "礼品码ListID"};
            if (giftCodes==null){
                return ;
            }
            /*JSONArray finaltables= JSONObject.parseArray(list);
            List<Finaltable> list1 = finaltables.toJavaList(Finaltable.class);*/
            //excel文件名
            String fileName = "礼品码Excel" + System.currentTimeMillis() + ".xls";
            //sheet名
            String sheetName = "礼品码";
            String[][] content = new String[giftCodes.size()][];
            for (int i = 0; i < giftCodes.size(); i++) {
                content[i] = new String[title.length];
                GiftCode giftCode = giftCodes.get(i);
                content[i][0] = String.valueOf(giftCode.getId());
                content[i][1] = giftCode.getGiftCode();
                content[i][2] = String.valueOf(giftCode.getGiftListId());
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
                response.getWriter().println("数据错误!!!");
                return;
            }
           //向前端发送下载流
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().println("数据错误!!!");
            return;
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
