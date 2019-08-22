package com.bjc.controller;

import com.bjc.entity.Rest;
import org.springframework.ui.Model;
import com.bjc.entity.OverTim;
import com.bjc.service.SelectOverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class SelectController {

    @Autowired
    private SelectOverTimeService selectOverTimeService;

    //查询加班全部记录
    @RequestMapping("/overtimelist")
    public String overtimeselect(Model model,OverTim overtime){
        System.out.println(overtime);
        List<OverTim> lists=selectOverTimeService.selectOverTime(overtime);
        model.addAttribute("lists",lists);
        return "overtimelist";
    }

    //查询调休全部记录
    @RequestMapping("/restlist")
    public String restselcet(Model model,Rest rest){
        List<Rest> list1=selectOverTimeService.selectRest(rest);
        model.addAttribute("list1",list1);
        return "restlist";
    }

}
