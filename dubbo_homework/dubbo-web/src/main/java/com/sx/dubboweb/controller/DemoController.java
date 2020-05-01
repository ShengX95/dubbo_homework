package com.sx.dubboweb.controller;

import com.sx.dubbo.serivce.AService;
import com.sx.dubbo.serivce.BService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shengx
 * @date 2020/5/1 14:07
 */
@Controller
@RequestMapping("/")
public class DemoController {
    @Reference
    AService aService;
    @Reference
    BService bService;
    @GetMapping("/serviceA")
    @ResponseBody
    public String doServiceA(String hello){
        return aService.sayHello(hello);
    }

    @GetMapping("/serviceB")
    @ResponseBody
    public String doServiceB(String hello){
        return bService.sayHello(hello);
    }
}
