package com.xiong.cloud.demo02;

import com.jnrsmcu.sdk.netdevice.*;

import java.text.SimpleDateFormat;

public class T1 extends Thread {

//    private Map<String,String> map=new HashMap<>();
    @Override
    public void run() {
        RSServer rsServer = RSServer.Initiate(2404);// 初始化
        //RSServer rsServer = RSServer.Initiate(2404,"C:/param.dat");
        rsServer.addDataListener(new IDataListener() {// 添加监听
            @Override
            public void receiveTimmingAck(TimmingAck data) {// 校时指令应答处理
                System.out.println("校时应答->设备编号:" + data.getDeviceId()
                        + "\t执行结果：" + data.getStatus());
            }

            @Override
            public void receiveTelecontrolAck(TelecontrolAck data) {// 遥控指令应答处理
                System.out.println("遥控应答->设备编号:" + data.getDeviceId()
                        + "\t继电器编号:" + data.getRelayId() + "\t执行结果:"
                        + data.getStatus());
            }

            @Override
            public void receiveStoreData(StoreData data) {// 已存储数据接收处理
                // 遍历节点数据。数据包括网络设备的数据以及各个节点数据。温湿度数据存放在节点数据中
                for (NodeData nd : data.getNodeList()) {
                    SimpleDateFormat sdf = new SimpleDateFormat(
                            "yy-MM-dd HH:mm:ss");
                    String str = sdf.format(nd.getRecordTime());
                    System.out.println("存储数据->设备地址:" + data.getDeviceId()
                            + "\t节点:" + nd.getNodeId() + "\t温度:" + nd.getTem()
                            + "\t湿度:" + nd.getHum() + "\t存储时间:" + str);
                }

            }

            @Override
            public void receiveRealtimeData(RealTimeData data) {
                Static.map.put("datas",data.getNodeList());
                // 实时数据接收处理
                // 遍历节点数据。数据包括网络设备的数据以及各个节点数据。温湿度数据存放在节点数据中
//                for (NodeData nd : data.getNodeList()) {
//                    System.out.println("实时数据->设备地址:" + data.getDeviceId()
//                            + "\t节点:" + nd.getNodeId() + "\t温度:" + nd.getTem()
//                            + "\t湿度:" + nd.getHum() + "\t经度:" + data.getLng()
//                            + "\t纬度:" + data.getLat() + "\t坐标类型:"
//                            + data.getCoordinateType() + "\t继电器状态:"
//                            + data.getRelayStatus());
//
//
//                    // Static.map.put(String.valueOf(nd.getNodeId()), String.valueOf(nd.getTem()));
//
//                }
                for (NodeData nd : data.getNodeList()) {
//                    System.out.println("实时数据->设备地址:" + data.getDeviceId()
//                            + "\t节点:" + nd.getNodeId() + "\t参数1:" + nd.getTem()
//                            + "\t参数2:" + nd.getHum() + "\t经度:" + data.getLng()
//                            + "\t纬度:" + data.getLat() + "\t坐标类型:"
//                            + data.getCoordinateType() + "\t继电器状态:"
//                            + data.getRelayStatus());

                    System.out.println("实时数据->设备地址:" + data.getDeviceId()
                            + "\t节点:" + nd.getNodeId() + "\t参数1:" + nd.getTem()
                            + "\t参数2:" + nd.getHum());
                    // Static.map.put(String.valueOf(nd.getNodeId()), String.valueOf(nd.getTem()));

                }

            }

            @Override
            public void receiveLoginData(LoginData data) {// 登录数据接收处理
                System.out.println("登录->设备地址:" + data.getDeviceId());

            }

            @Override
            public void receiveParamIds(ParamIdsData data) {
                String str = "设备参数编号列表->设备编号：" + data.getDeviceId()
                        + "\t参数总数量：" + data.getTotalCount() + "\t本帧参数数量："
                        + data.getCount() + "\r\n";
                for (int paramId : data.getPararmIdList())// 遍历设备中参数id编号
                {
                    str += paramId + ",";
                }
                System.out.println(str);

            }

            @Override
            public void receiveParam(ParamData data) {
                String str = "设备参数->设备编号：" + data.getDeviceId() + "\r\n";

                for (ParamItem pararm : data.getParameterList()) {
                    str += "参数编号："
                            + pararm.getParamId()
                            + "\t参数描述："
                            + pararm.getDescription()
                            + "\t参数值："
                            + (pararm.getValueDescription() == null ? pararm
                            .getValue() : pararm.getValueDescription()
                            .get(pararm.getValue())) + "\r\n";
                }
                System.out.println(str);

            }

            @Override
            public void receiveWriteParamAck(WriteParamAck data) {
                String str = "下载设备参数->设备编号：" + data.getDeviceId() + "\t参数数量："
                        + data.getCount() + "\t"
                        + (data.isSuccess() ? "下载成功" : "下载失败");
                System.out.println(str);

            }

            @Override
            public void receiveTransDataAck(TransDataAck data) {
                String str = "数据透传->设备编号：" + data.getDeviceId() + "\t响应结果："
                        + data.getData() + "\r\n字节数：" + data.getTransDataLen();
                System.out.println(str);

            }
        });


        try {
            rsServer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("初始化完成");
    }
}
