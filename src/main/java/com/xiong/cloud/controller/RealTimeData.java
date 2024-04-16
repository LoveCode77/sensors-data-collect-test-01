package com.xiong.cloud.controller;

import com.xiong.cloud.demo02.Static;
import com.jnrsmcu.sdk.netdevice.NodeData;
import com.xiong.cloud.service.RealTimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("realTimeData")
public class RealTimeData {
    @Autowired
    private RealTimeDataService realTimeDataService;
    @GetMapping("demo")
    public String demo(HttpServletRequest request){
        StringBuffer requestURL = request.getRequestURL();
        return "you can get real-time data!";
    }
    @GetMapping("allData")
    public Map allData(){
        List<NodeData> datas = Static.map.get("datas");
        List<Map<String,String>> list=new ArrayList<>();
        Map<String,String> map;
        for (NodeData data : datas) {
            map=new HashMap<>();
            map.put("nodeId",String.valueOf(data.getNodeId()));
            map.put("parameter01",String.valueOf(data.getTem()));
            map.put("parameter02",String.valueOf(data.getHum()));
            list.add(map);
        }
        Map<String,String> maps=new HashMap<>();
        for (Map<String, String>  m: list) {
            if(m.get("nodeId").equals("1")) {
                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
//                Double potassium = Double.valueOf(m.get("parameter02")) * 10;

                maps.put("一层氮含量",nitrogen+"");
                maps.put("一层磷含量",phosphorus+"");
            }
            if(m.get("nodeId").equals("2")) {
//                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
//                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
                Double potassium = Double.valueOf(m.get("parameter01")) * 10;

//                maps.put("一层氮含量",potassium+"");
//                maps.put("一层钾含量",potassium+"");
            }


            if(m.get("nodeId").equals("9")) {
                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
//                Double potassium = Double.valueOf(m.get("parameter02")) * 10;

                maps.put("5层氮含量",nitrogen+"");
                maps.put("5层磷含量",phosphorus+"");
            }
            if(m.get("nodeId").equals("10")) {
//                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
//                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
                Double potassium = Double.valueOf(m.get("parameter02")) * 10;

//                maps.put("一层氮含量",potassium+"");
                maps.put("5层钾含量",potassium+"");
            }

            if(m.get("nodeId").equals("17")){
                maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("空气湿度",m.get("parameter02")+" %RH");
            }
            if(m.get("nodeId").equals("16")){
//                maps.put("地上温度",m.get("parameter01")+" ℃");
                double light=Double.valueOf(m.get("parameter02"))*10;
                maps.put("光照度", light+" Lux");
            }
            if(m.get("nodeId").equals("15")){
              //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("风速",m.get("parameter02")+" m/s");
            }
            if(m.get("nodeId").equals("14")){
                Double gear=Double.valueOf(m.get("parameter02"))*10;
                Double angle=Double.valueOf(m.get("parameter01"))*10;

                String windDirection;
                if(gear==0&&angle==0){
                    windDirection="北风";
                }else if (gear==1&&angle==45){
                    windDirection="东北风";
                }else if (gear==2&&angle==90){
                    windDirection="东风";
                }else if (gear==3&&angle==135){
                    windDirection="东南风";
                }else if (gear==4&&angle==180){
                    windDirection="南风";
                }else if (gear==5&&angle==225){
                    windDirection="西南风";
                }else if (gear==6&&angle==45){
                    windDirection="西风";
                }else if (gear==6&&angle==45) {
                    windDirection = "西北风";
                } else{
                    windDirection="风向不明，请等待";
                }


                    //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("风向",windDirection);
            }
            if(m.get("nodeId").equals("13")){
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                double light=Double.valueOf(m.get("parameter02"))*10;
                maps.put("空气氮含量",light+" ppm");
            }
            if(m.get("nodeId").equals("11")){
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("电导率",m.get("parameter02")+" us/cm");
            }
            if(m.get("nodeId").equals("11")){
                maps.put("土温",m.get("parameter01")+" ℃");
                maps.put("土湿",m.get("parameter02")+" %RH");
            }
            if(m.get("nodeId").equals("18")){
                maps.put("雨雪信息",m.get("parameter01")+" ");
//                maps.put("土湿",m.get("parameter02")+" %RH");
            }
        }


        return maps;
    }
    @GetMapping("getFiveLayerSnsorData")
    public Map getFiveLayerSnsorData(){
        Map map = realTimeDataService.getFiveLayerSnsorData();
        return map;
    }
}
