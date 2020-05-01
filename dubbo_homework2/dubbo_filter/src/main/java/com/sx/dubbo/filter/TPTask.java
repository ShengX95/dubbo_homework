package com.sx.dubbo.filter;

import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shengx
 * @date 2020/5/1 18:21
 */
public class TPTask extends TimerTask {
    private ConcurrentHashMap<String, MonitorWaterLineCalculator> methodTimeMap = new ConcurrentHashMap<>();
    public TPTask(ConcurrentHashMap<String, MonitorWaterLineCalculator> methodTimeMap){
        this.methodTimeMap = methodTimeMap;
    }
    @Override
    public void run() {
        for (Map.Entry<String, MonitorWaterLineCalculator> entry : methodTimeMap.entrySet()) {
            String method = entry.getKey();
            MonitorWaterLineCalculator calculator = entry.getValue();
            System.out.println("method: " + method + " TP90:" + calculator.getResult());
        }
    }
}
