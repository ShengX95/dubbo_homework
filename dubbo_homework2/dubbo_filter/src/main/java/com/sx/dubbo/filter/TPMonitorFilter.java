package com.sx.dubbo.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shengx
 * @date 2020/5/1 17:41
 */
@Activate(group = CommonConstants.CONSUMER)
public class TPMonitorFilter implements Filter {
    private ConcurrentHashMap<String, MonitorWaterLineCalculator> methodTimeMap = new ConcurrentHashMap<>();

    public TPMonitorFilter(){
        new Timer("methodTPTimer").scheduleAtFixedRate(new TPTask(methodTimeMap), 1000,5000);
    }
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Long start = System.currentTimeMillis();
        String method = invocation.getMethodName();
        try {
            return invoker.invoke(invocation);
        }finally {
            Long end = System.currentTimeMillis();
            Long time = end - start;
//            System.out.println(time);
            if(methodTimeMap.containsKey(method)){
                methodTimeMap.get(method).accumulate(time);
            }else {
                methodTimeMap.put(method, new MonitorWaterLineCalculator(90));
            }
        }
    }
}
