package com.xiong.cloud.demo02;

public class T2 extends Thread {
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Static.map);
        }
    }
}
