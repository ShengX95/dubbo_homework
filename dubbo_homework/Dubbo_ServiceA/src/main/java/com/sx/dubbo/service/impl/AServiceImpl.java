package com.sx.dubbo.service.impl;

import com.sx.dubbo.serivce.AService;
import com.sx.dubbo.serivce.BService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author shengx
 * @date 2020/5/1 13:28
 */
public class AServiceImpl implements AService {
    @Override
    public String sayHello(String hello) {
        String ip = RpcContext.getContext().getAttachment("clientIp");
        return "AService:" + hello + " from ip:" + ip;
    }
}
