package com.abcde.imooc.spring.producer;


import com.abcde.imooc.spring.ProducerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("producer.xml");

        ProducerService service = context.getBean(ProducerService.class);

        for (int i = 0; i < 100; i++) {
            service.sendMessage("test" + i);
        }

        context.close();
    }
}
