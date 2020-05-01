package com.sx.dubbo.service.impl;

import com.sx.dubbo.serivce.BService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author shengx
 * @date 2020/5/1 13:28
 */
public class BServiceImpl implements BService {
    @Override
    public String sayHello(String hello) {
        String ip = RpcContext.getContext().getAttachment("clientIp");
        return "BService:" + hello + " from ip:" + ip;
    }
}
