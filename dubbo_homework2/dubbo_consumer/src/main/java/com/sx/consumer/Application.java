package com.sx.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengx
 * @date 2020/5/1 17:29
 */
public class Application {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        DemoServiceComponent demoServiceComponent = context.getBean(DemoServiceComponent.class);
        Executor executor = Executors.newFixedThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger();
        while(true){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(demoServiceComponent.sayA("a" + atomicInteger.incrementAndGet()));
                    System.out.println(demoServiceComponent.sayB("b" + atomicInteger.incrementAndGet()));
                    System.out.println(demoServiceComponent.sayC("c" + atomicInteger.incrementAndGet()));
                }
            });
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.sx.consumer")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = {"com.sx.consumer"})
    static class ConsumerConfiguration {

    }

}
