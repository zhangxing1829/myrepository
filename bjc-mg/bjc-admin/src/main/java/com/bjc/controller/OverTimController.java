package com.bjc.controller;

import com.bjc.Utils.DateUtils;
import com.bjc.entity.OverTim;
import com.bjc.service.OverTimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/bs")
public class OverTimController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private OverTimService overTimService;
    @RequestMapping("/overtim")
    public  String pageOver (){
        return "bs/overtim";
    }

    @RequestMapping("overtim.do")
    public String insertOverTim(OverTim overTim , Model model){
        Date dateNow = new Date();
        System.out.println(dateNow);
        if (DateUtils.convertStringToDate(sdf.format(dateNow)).getTime()>=DateUtils.convertStringToDate(overTim.getStartTime()).getTime()){
            model.addAttribute("errmsg","开始时间小于当前时间");
            return  "bs/overTim";
        } else  if (!OverTimController.day(overTim)){
            model.addAttribute("errmsg","开始时间大于结束时间，不能提交");
            return  "bs/overTim";
        }else {
            this.overTimService.insertOverTim(overTim);
            return "overtim_list";
        }
    }

    /**
     * 判断开始日期与结束日期、现在时间的关系
     * @param overTim
     * @return
     */
    public  static  boolean day(OverTim overTim){

        if (DateUtils.convertStringToDate(overTim.getStartTime()).getTime()>DateUtils.convertStringToDate(overTim.getEndTime()).getTime()){
            return false;
        } else
            return true;
    }


}
