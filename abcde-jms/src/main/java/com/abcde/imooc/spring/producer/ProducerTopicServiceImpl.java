package com.abcde.imooc.spring.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

public class ProducerTopicServiceImpl implements ProducerService{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("topicDestination")
    private Destination destination;

    @Override
    public void sendMessage(final String message) {
        //使用JmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });

        System.out.println("发送消息 -- > " + message);
    }
}
