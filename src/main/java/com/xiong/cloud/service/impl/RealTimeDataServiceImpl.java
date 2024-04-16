package com.xiong.cloud.service.impl;

import com.jnrsmcu.sdk.netdevice.NodeData;
import com.xiong.cloud.demo02.Static;
import com.xiong.cloud.service.RealTimeDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class RealTimeDataServiceImpl implements RealTimeDataService {
    @Override
    public Map getAllData() {
        //获取数据源
        List<NodeData> datas = Static.map.get("datas");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        //对数据源数据按节点分类
        for (NodeData data : datas) {
            map = new HashMap<>();
            map.put("nodeId", String.valueOf(data.getNodeId()));
            map.put("parameter01", String.valueOf(data.getTem()));
            map.put("parameter02", String.valueOf(data.getHum()));
            list.add(map);
        }

        Map<String, String> maps = new HashMap<>();
        for (Map<String, String> m : list) {

            if (m.get("nodeId").equals("1")) {
                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;

                maps.put("一层氮含量", nitrogen + "");
                maps.put("一层磷含量", phosphorus + "");
            }
            if (m.get("nodeId").equals("2")) {
//                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
//                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
                Double potassium = Double.valueOf(m.get("parameter01")) * 10;

//                maps.put("一层氮含量",potassium+"");
//                maps.put("一层钾含量",potassium+"");
            }


            if (m.get("nodeId").equals("9")) {
                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
//                Double potassium = Double.valueOf(m.get("parameter02")) * 10;

                maps.put("5层氮含量", nitrogen + "");
                maps.put("5层磷含量", phosphorus + "");
            }
            if (m.get("nodeId").equals("10")) {
//                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
//                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
                Double potassium = Double.valueOf(m.get("parameter02")) * 10;

//                maps.put("一层氮含量",potassium+"");
                maps.put("5层钾含量", potassium + "");
            }

            if (m.get("nodeId").equals("17")) {
                maps.put("地上温度", m.get("parameter01") + " ℃");
                maps.put("空气湿度", m.get("parameter02") + " %RH");
            }
            if (m.get("nodeId").equals("16")) {
//                maps.put("地上温度",m.get("parameter01")+" ℃");
                double light = Double.valueOf(m.get("parameter02")) * 10;
                maps.put("光照度", light + " Lux");
            }
            if (m.get("nodeId").equals("15")) {
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("风速", m.get("parameter02") + " m/s");
            }
            if (m.get("nodeId").equals("14")) {
                Double gear = Double.valueOf(m.get("parameter02")) * 10;
                Double angle = Double.valueOf(m.get("parameter01")) * 10;

                String windDirection;
                if (gear == 0 && angle == 0) {
                    windDirection = "北风";
                } else if (gear == 1 && angle == 45) {
                    windDirection = "东北风";
                } else if (gear == 2 && angle == 90) {
                    windDirection = "东风";
                } else if (gear == 3 && angle == 135) {
                    windDirection = "东南风";
                } else if (gear == 4 && angle == 180) {
                    windDirection = "南风";
                } else if (gear == 5 && angle == 225) {
                    windDirection = "西南风";
                } else if (gear == 6 && angle == 45) {
                    windDirection = "西风";
                } else if (gear == 6 && angle == 45) {
                    windDirection = "西北风";
                } else {
                    windDirection = "风向不明，请等待";
                }


                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("风向", windDirection);
            }
            if (m.get("nodeId").equals("13")) {
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                double light = Double.valueOf(m.get("parameter02")) * 10;
                maps.put("空气氮含量", light + " ppm");
            }
            if (m.get("nodeId").equals("11")) {
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("电导率", m.get("parameter02") + " us/cm");
            }
            if (m.get("nodeId").equals("11")) {
                maps.put("土温", m.get("parameter01") + " ℃");
                maps.put("土湿", m.get("parameter02") + " %RH");
            }
            if (m.get("nodeId").equals("18")) {
                maps.put("雨雪信息", m.get("parameter01") + " ");
//                maps.put("土湿",m.get("parameter02")+" %RH");
            }
        }
        return maps;
    }

    public Map getAllData1() {
        //获取数据源
        List<NodeData> datas = Static.map.get("datas");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        //对数据源数据按节点分类
        for (NodeData data : datas) {
            map = new HashMap<>();
            map.put("nodeId", String.valueOf(data.getNodeId()));
            map.put("parameter01", String.valueOf(data.getTem()));
            map.put("parameter02", String.valueOf(data.getHum()));
            list.add(map);
        }

        Map<String, String> maps = new HashMap<>();
        for (Map<String, String> m : list) {

            if (m.get("nodeId").equals("1")) {
                Double nitrogen = Double.valueOf(m.get("parameter01"));
                Double phosphorus = Double.valueOf(m.get("parameter02"));

                maps.put("一层氮含量", nitrogen + "");
                maps.put("一层磷含量", phosphorus + "");
            }
            if (m.get("nodeId").equals("2")) {
//                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
//                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
                Double potassium = Double.valueOf(m.get("parameter01")) * 10;

//                maps.put("一层氮含量",potassium+"");
//                maps.put("一层钾含量",potassium+"");
            }


            if (m.get("nodeId").equals("9")) {
                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
//                Double potassium = Double.valueOf(m.get("parameter02")) * 10;

                maps.put("5层氮含量", nitrogen + "");
                maps.put("5层磷含量", phosphorus + "");
            }
            if (m.get("nodeId").equals("10")) {
//                Double nitrogen = Double.valueOf(m.get("parameter01")) * 10;
//                Double phosphorus = Double.valueOf(m.get("parameter02")) * 10;
                Double potassium = Double.valueOf(m.get("parameter02")) * 10;

//                maps.put("一层氮含量",potassium+"");
                maps.put("5层钾含量", potassium + "");
            }

            if (m.get("nodeId").equals("17")) {
                maps.put("地上温度", m.get("parameter01") + " ℃");
                maps.put("空气湿度", m.get("parameter02") + " %RH");
            }
            if (m.get("nodeId").equals("16")) {
//                maps.put("地上温度",m.get("parameter01")+" ℃");
                double light = Double.valueOf(m.get("parameter02")) * 10;
                maps.put("光照度", light + " Lux");
            }
            if (m.get("nodeId").equals("15")) {
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("风速", m.get("parameter02") + " m/s");
            }
            if (m.get("nodeId").equals("14")) {
                Double gear = Double.valueOf(m.get("parameter02")) * 10;
                Double angle = Double.valueOf(m.get("parameter01")) * 10;

                String windDirection;
                if (gear == 0 && angle == 0) {
                    windDirection = "北风";
                } else if (gear == 1 && angle == 45) {
                    windDirection = "东北风";
                } else if (gear == 2 && angle == 90) {
                    windDirection = "东风";
                } else if (gear == 3 && angle == 135) {
                    windDirection = "东南风";
                } else if (gear == 4 && angle == 180) {
                    windDirection = "南风";
                } else if (gear == 5 && angle == 225) {
                    windDirection = "西南风";
                } else if (gear == 6 && angle == 45) {
                    windDirection = "西风";
                } else if (gear == 6 && angle == 45) {
                    windDirection = "西北风";
                } else {
                    windDirection = "风向不明，请等待";
                }


                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("风向", windDirection);
            }
            if (m.get("nodeId").equals("13")) {
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                double light = Double.valueOf(m.get("parameter02")) * 10;
                maps.put("空气氮含量", light + " ppm");
            }
            if (m.get("nodeId").equals("11")) {
                //  maps.put("地上温度",m.get("parameter01")+" ℃");
                maps.put("电导率", m.get("parameter02") + " us/cm");
            }
            if (m.get("nodeId").equals("11")) {
                maps.put("土温", m.get("parameter01") + " ℃");
                maps.put("土湿", m.get("parameter02") + " %RH");
            }
            if (m.get("nodeId").equals("18")) {
                maps.put("雨雪信息", m.get("parameter01") + " ");
//                maps.put("土湿",m.get("parameter02")+" %RH");
            }
        }
        return maps;
    }

    @Override
    public Map getFiveLayerSnsorData() {
        //返回数据集
        Map<String, String> data = new HashMap<>();
        //获取数据源
        List<Map<String, String>> source = getSource();
        for (Map<String, String> map : source) {
            //第5层
            if (map.get("nodeId").equals("1")) {
                //温度
                Double temperature = Double.valueOf(map.get("parameter01"));
                //含水百分比
                Double moisturePercentage = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第5层的温度", temperature + "℃");
                data.put("多层传感器第5层的土壤含水百分比", moisturePercentage + "%");
            }
            if (map.get("nodeId").equals("2")) {
                //该数据含义暂时未知
                Double temp = Double.valueOf(map.get("parameter01"));
                //含氮量
                Double nitrogenContent = Double.valueOf(map.get("parameter02"));

                //data.put("多层传感器第5层的温度", temp + "℃");
                data.put("多层传感器第5层的土壤含氮量", nitrogenContent + " ");
            }
            if (map.get("nodeId").equals("3")) {
                //含磷量
                Double phosphorusContent = Double.valueOf(map.get("parameter01"));
                //含钾量
                Double potassiumContent = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第5层的土壤含磷量", phosphorusContent + " ");
                data.put("多层传感器第5层的土壤含钾量", potassiumContent + " ");
            }
            //第4层
            if (map.get("nodeId").equals("4")) {
                //温度
                Double temperature = Double.valueOf(map.get("parameter01"));
                //含水百分比
                Double moisturePercentage = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第4层的温度", temperature + "℃");
                data.put("多层传感器第4层的土壤含水百分比", moisturePercentage + "%");
            }
            if (map.get("nodeId").equals("5")) {
                //该数据含义暂时未知
                Double temp = Double.valueOf(map.get("parameter01"));
                //含氮量
                Double nitrogenContent = Double.valueOf(map.get("parameter02"));

                //data.put("多层传感器第5层的温度", temp + "℃");
                data.put("多层传感器第4层的土壤含氮量", nitrogenContent + " ");
            }
            if (map.get("nodeId").equals("6")) {
                //含磷量
                Double phosphorusContent = Double.valueOf(map.get("parameter01"));
                //含钾量
                Double potassiumContent = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第4层的土壤含磷量", phosphorusContent + " ");
                data.put("多层传感器第4层的土壤含钾量", potassiumContent + " ");
            }
            //第3层
            if (map.get("nodeId").equals("7")) {
                //温度
                Double temperature = Double.valueOf(map.get("parameter01"));
                //含水百分比
                Double moisturePercentage = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第3层的温度", temperature + "℃");
                data.put("多层传感器第3层的土壤含水百分比", moisturePercentage + "%");
            }
            if (map.get("nodeId").equals("8")) {
                //该数据含义暂时未知
                Double temp = Double.valueOf(map.get("parameter01"));
                //含氮量
                Double nitrogenContent = Double.valueOf(map.get("parameter02"));

                //data.put("多层传感器第5层的温度", temp + "℃");
                data.put("多层传感器第3层的土壤含氮量", nitrogenContent + " ");
            }
            if (map.get("nodeId").equals("9")) {
                //含磷量
                Double phosphorusContent = Double.valueOf(map.get("parameter01"));
                //含钾量
                Double potassiumContent = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第3层的土壤含磷量", phosphorusContent + " ");
                data.put("多层传感器第3层的土壤含钾量", potassiumContent + " ");
            }
            //第2层
            if (map.get("nodeId").equals("21")) {
                //温度
                Double temperature = Double.valueOf(map.get("parameter01"));
                //含水百分比
                Double moisturePercentage = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第2层的温度", temperature + "℃");
                data.put("多层传感器第2层的土壤含水百分比", moisturePercentage + "%");
            }
            if (map.get("nodeId").equals("22")) {
                //该数据含义暂时未知
                Double temp = Double.valueOf(map.get("parameter01"));
                //含氮量
                Double nitrogenContent = Double.valueOf(map.get("parameter02"));

                //data.put("多层传感器第5层的温度", temp + "℃");
                data.put("多层传感器第2层的土壤含氮量", nitrogenContent + " ");
            }
            if (map.get("nodeId").equals("23")) {
                //含磷量
                Double phosphorusContent = Double.valueOf(map.get("parameter01"));
                //含钾量
                Double potassiumContent = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第2层的土壤含磷量", phosphorusContent + " ");
                data.put("多层传感器第2层的土壤含钾量", potassiumContent + " ");
            }
            //第1层
            if (map.get("nodeId").equals("23")) {
                //温度
                Double temperature = Double.valueOf(map.get("parameter01"));
                //含水百分比
                Double moisturePercentage = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第1层的温度", temperature + "℃");
                data.put("多层传感器第1层的土壤含水百分比", moisturePercentage + "%");
            }
            if (map.get("nodeId").equals("25")) {
                //该数据含义暂时未知
                Double temp = Double.valueOf(map.get("parameter01"));
                //含氮量
                Double nitrogenContent = Double.valueOf(map.get("parameter02"));

                //data.put("多层传感器第5层的温度", temp + "℃");
                data.put("多层传感器第1层的土壤含氮量", nitrogenContent + " ");
            }
            if (map.get("nodeId").equals("26")) {
                //含磷量
                Double phosphorusContent = Double.valueOf(map.get("parameter01"));
                //含钾量
                Double potassiumContent = Double.valueOf(map.get("parameter02"));

                data.put("多层传感器第1层的土壤含磷量", phosphorusContent + " ");
                data.put("多层传感器第1层的土壤含钾量", potassiumContent + " ");
            }


        }

        return data;
    }

    public static List getSource() {
        //获取数据源
        List<NodeData> datas = Static.map.get("datas");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        //对数据源数据按节点分类
        for (NodeData data : datas) {
            map = new HashMap<>();
            map.put("nodeId", String.valueOf(data.getNodeId()));
            map.put("parameter01", String.valueOf(data.getTem()));
            map.put("parameter02", String.valueOf(data.getHum()));
            list.add(map);
        }

        return list;
    }

    public Map<String, String> getLayer(Map<String, String> map, Map<String, String> data, String[] array) {
        if (map.get("nodeId").equals(array[0])) {
            //温度
            Double temperature = Double.valueOf(map.get("parameter01"));
            //含水百分比
            Double moisturePercentage = Double.valueOf(map.get("parameter02"));

            data.put("多层传感器第5层的温度", temperature + "℃");
            data.put("多层传感器第5层的土壤含水百分比", moisturePercentage + "%");
        }
        if (map.get("nodeId").equals(array[1])) {
            //该数据含义暂时未知
            Double temp = Double.valueOf(map.get("parameter01"));
            //含氮量
            Double nitrogenContent = Double.valueOf(map.get("parameter02"));

            //data.put("多层传感器第5层的温度", temp + "℃");
            data.put("多层传感器第5层的土壤含氮量", nitrogenContent + " ");
        }

        if (map.get("nodeId").equals(array[2])) {
            //含磷量
            Double phosphorusContent = Double.valueOf(map.get("parameter01"));
            //含钾量
            Double potassiumContent = Double.valueOf(map.get("parameter02"));

            data.put("多层传感器第5层的土壤含磷量", phosphorusContent + " ");
            data.put("多层传感器第5层的土壤含钾量", potassiumContent + " ");
        }

        return data;
    }
}
