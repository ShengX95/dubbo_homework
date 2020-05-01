package com.sx.consumer;

import com.sx.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author shengx
 * @date 2020/5/1 17:30
 */
@Component
public class DemoServiceComponent {
    @Reference
    private DemoService demoService;

    public String sayA(String hello) {
        return demoService.methodA(hello);
    }

    public String sayB(String hello) {
        return demoService.methodB(hello);
    }

    public String sayC(String hello) {
        return demoService.methodC(hello);
    }
}
