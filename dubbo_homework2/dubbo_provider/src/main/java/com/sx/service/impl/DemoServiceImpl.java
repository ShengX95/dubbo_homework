package com.sx.service.impl;

import com.sx.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author shengx
 * @date 2020/5/1 17:16
 */
@Service
public class DemoServiceImpl implements DemoService {
    private Random random = new Random();
    @Override
    public String methodA(String method) {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "methodA:" + method;
    }

    @Override
    public String methodB(String method) {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "methodB:" + method;
    }

    @Override
    public String methodC(String method) {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "methodC:" + method;
    }
}
