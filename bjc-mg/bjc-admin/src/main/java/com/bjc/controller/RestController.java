package com.bjc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.bjc.Utils.DateUtils;
import com.bjc.entity.Rest;
import com.bjc.entity.RestOverTime;
import com.bjc.entity.User;
import com.bjc.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/bs")
public class RestController extends  BaseController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 调休跳转页面
     * @return
     */
    @RequestMapping("/rest")
    public String lrest(){
        return "/bs/rest";
    }


        @Autowired
        private RestService restService;

        @RequestMapping("/{page}")
        public  String  rest(Model model, @PathVariable String page){
                    //System.out.println(getCurrentLoginId());
                     List<Rest> rest=   restService.selectByUId(getCurrentLoginId());
                       // System.out.println(rest.get(0));
                        model.addAttribute("rest",rest.get(0));
                        System.out.println(111111);
            return "bs/"+page;
        }

//        @RequestMapping(value = "/rest.do", method = RequestMethod.POST)
//        //@ResponseBody
//        public JSONObject  insertRest(Rest rest ,Model model, HttpServletResponse response){
//            System.out.println(rest);
//            Map<String, Object> map = new HashMap<String, Object>();
//            JSONObject result=new  JSONObject();
//
////            List<Rest> restTime=   restService.selectByUId(getCurrentLoginId());
////            rest.setUId(getCurrentLoginId());
////            model.addAttribute("rest",restTime.get(0));
//            Date dateNow = new Date();
//            System.out.println(dateNow);
//            if (DateUtils.convertStringToDate(sdf.format(dateNow)).getTime()>=DateUtils.convertStringToDate(rest.getStartTime()).getTime()){
//                System.out.println(1);
//                result.put("errres", 101);
//                result.put("errmsg","开始时间小于当前时间");
//                result.put("inputfocus","startTime");
//            }else  if (!RestController.restApply(rest)){
//                System.out.println(222);
//                result.put("errres", 102);
//                result.put("errmsg","剩余的调休天数为"+rest.getRestTime()+"天,不能调休"+rest.getApplyRestTime()+"天");
//                result.put("inputfocus","applyRestTime");
//            } else  if (!RestController.day(rest)){
//                System.out.println(3);
//                result.put("errres", 103);
//                result.put("errmsg","开始时间大于结束时间，不能提交");
//                result.put("inputfocus","startTime");
//            }else {
//                System.out.println(4);
//                rest.setRestTime(rest.getRestTime()-rest.getApplyRestTime());
//                this.restService.insertAllColumn(rest);
//                result.put("errres",200);
//            }
//          // ResponseUtil.write(response,result);
//            return result ;
//        }
@RequestMapping(value = "/rest.do", method = RequestMethod.POST)

public String   insertRest(Rest rest , ModelMap map){
    System.out.println(rest);
            List<Rest> restTime= restService.selectByUId(getCurrentLoginId());
            rest.setUId(getCurrentLoginId());
            map.addAttribute("rest",restTime.get(0));
    Date dateNow = new Date();
    System.out.println(dateNow);
    if (DateUtils.convertStringToDate(sdf.format(dateNow)).getTime()>=DateUtils.convertStringToDate(rest.getStartTime()).getTime()){
        map.addAttribute("errmsg","开始时间小于当前时间");
        return  "bs/rest";
    }else  if (!RestController.restApply(rest)){
        map.addAttribute("errmsg","剩余的调休天数为"+rest.getRestTime()+"天,不能调休"+rest.getApplyRestTime()+"天");
        return  "bs/rest";
    } else  if (!RestController.day(rest)){
        map.addAttribute("errmsg","开始时间大于结束时间，不能提交");
        return  "bs/rest";
    }else {
        rest.setRestTime(rest.getRestTime()-rest.getApplyRestTime());
        this.restService.insertAllColumn(rest);
       return "redirect:/bs/list";
    }
}

    @RequestMapping("/list")
    public  String  restList(){
        return "bs/rest_list";
    }

@ResponseBody
@RequestMapping("/rest/getList")
public Map<String,Object> getList(){
    Map<String,Object> result= new HashMap<>();
            List<Rest> list = restService.listAll();
            System.out.println(list);
            result.put("total",10);
            result.put("rows",list);
//            result.put("rows","Rest{restId=1, uId=2, startTime=2019-06-26 11:13:49.0, endTime=2019-06-27 11:14:02.0, restTime=10.0, applyRestTime=1.0, reason=1, month=null, rStatus=0, user=User{uId=0, username=江魁, email=null, password=null, managerNumber=null, sex=null, number=B-51234, hwNumber=null, deptNumber=null, phone=null, weixin=null, salt=null, status=null}}");
            System.out.println(result);
            return result;
}


    @RequestMapping("/chart")
    public  String  restChart(){
        return  "chart/charts";
     }


    //按照部门查询
    @RequestMapping(value = "/produceRestTime.do",method = RequestMethod.POST)
    @ResponseBody
    public  JSONArray  produceRestTime(User user, Model model){
        System.out.println(123);

        //接收前端传来的参数
        Map<String,Object> map= new HashMap<>();
        map.put("deptNumber",user.getDeptNumber());
        map.put("deptNumber1",user.getDeptNumber1());
        map.put("startTime",user.getStartTime());
        map.put("endTime",user.getEndTime());

        //XML：produceRest//按照部门查询出结果，把结果放在result返回给前端
        List<RestOverTime> produceRestTime= restService.produceRest(map);
        model.addAttribute("result",produceRestTime);
        System.out.println(produceRestTime.toString());



        String restMonth;

        JSONArray array1,array2,objects1,objects2;
        JSONObject result1,result2;
        JSONArray outer=new JSONArray();
        array1=new JSONArray();
        array2=new JSONArray();
        for(int i=0;i< produceRestTime.size(); i++){
            restMonth=produceRestTime.get(i).getMonth();//第一个for循环获取第i条记录的月份
            System.out.println("aaa"+restMonth);
                System.out.println("---------------"+produceRestTime.get(i).getMonth());
                    objects2=new JSONArray();
                        System.out.println("bbbb"+produceRestTime.get(i).getMonth());
                        objects2.add(produceRestTime.get(i).getYear());//调休月份
                        objects2.add(produceRestTime.get(i).getOverTime());//加班总时长
                        array2.add(objects2);


                    objects1=new JSONArray();

                        objects1.add(produceRestTime.get(i).getYear());//调休月份
                        //objects1.add(produceRestTime.get(j).getRestTime());//剩余调休天数
                        objects1.add(produceRestTime.get(i).getApplyRestTime());//申请调休天数
                        array1.add(objects1);


        }
        if (array1.size()>0 && array2.size()>0){

            result2=new JSONObject();
            result2.put("name",user.getDeptNumber()+"_"+user.getDeptNumber1()+"加班总时长");//部门编号
            result2.put("data",array2);//月份、天数
            outer.add(result2);

            result1=new JSONObject();
            result1.put("data",array1);//月份、天数
            result1.put("name",user.getDeptNumber()+"_"+user.getDeptNumber1()+"调休总时长");//部门编号
            outer.add(result1);

            System.out.println(result1);
            System.out.println(result2);
        }

        System.out.println(outer);
        return RestController.docList(outer);
    }



//按照工号查询
//    @RequestMapping(value = "/produceRestNumber.do",method = RequestMethod.POST)
//    @ResponseBody
//    public  JSONArray  produceRestNumber(User user, Model model){
//        System.out.println(123);
//        Map<String,Object> map= new HashMap<>();
//        map.put("number",user.getNumber());
//        //map.put("deptNumber",user.getDeptNumber());
//
//        List<Rest> produceRestNumber= restService.produceRestNumber(map);
//        model.addAttribute("result",produceRestNumber);
//        System.out.println(produceRestNumber.toString());
//        String restName;
//        long restId;
//        JSONArray array1,objects1;
//        JSONObject result;
//        JSONArray outer=new JSONArray();
//        for(int i=0;i< produceRestNumber.size(); i++){
//                restName=produceRestNumber.get(i).getUser().getUsername();
//                restId=produceRestNumber.get(i).getUId();
//                array1=new JSONArray();
//                for (int j=0; j<produceRestNumber.size(); j++){
//                    objects1=new JSONArray();
//                    if (restId==produceRestNumber.get(j).getUId()) {
//                        objects1.add(produceRestNumber.get(j).getMonth());//调休月份
//                        objects1.add(produceRestNumber.get(j).getRestTime());//剩余调休天数
//                        array1.add(objects1);
//                    }
//                }
//            if (array1.size()>0){
//                result=new JSONObject();
//                result.put("name",restName);
//                result.put("data",array1);
//                outer.add(result);
//            }
//        }
//        //System.out.println(outer);
//        //System.out.println(RestController.docList(outer));
//
//        return RestController.docList(outer);
//    }



private  static JSONArray   docList(JSONArray jsonarray) {
    Set<String> set = new HashSet<String>();
    JSONArray doclist=new JSONArray();
    int num = 0;
    if (jsonarray.size()> 0) {
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject jsonObject = jsonarray.getJSONObject(i);
            if (set.add(jsonObject.toString().replace(" ", ""))) {
                num++;
                doclist.add(jsonObject);
            }
        }
    }
    return doclist;
}

    /**
     * 判断是否有剩余的调休时间
     * @param rest
     * @return
     */
    public  static  boolean restApply(Rest rest){
        if (rest.getApplyRestTime()<= rest.getRestTime()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断开始日期与结束日期、现在时间的关系
     * @param rest
     * @return
     */
    public  static  boolean day(Rest rest){

        if (DateUtils.convertStringToDate(rest.getStartTime()).getTime()>DateUtils.convertStringToDate(rest.getEndTime()).getTime()){
            return false;
        } else
            return true;
    }

}