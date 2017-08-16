package com.abcde.imooc.spring.producer;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("producer.xml");

        ProducerService service = (ProducerService) context.getBean("producerTopicServiceImpl");

        for (int i = 0; i < 100; i++) {
            service.sendMessage("test" + i);
        }

        context.close();
    }
}
