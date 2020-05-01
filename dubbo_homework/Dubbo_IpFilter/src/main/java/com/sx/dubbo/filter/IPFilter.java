package com.sx.dubbo.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author shengx
 * @date 2020/5/1 14:47
 */
@Activate(group = CommonConstants.CONSUMER)
public class IPFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            InetAddress localHost = Inet4Address.getLocalHost();
            RpcContext.getContext().setAttachment("clientIp", localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return invoker.invoke(invocation);
    }
}
