package com.zc.rocketmq.simple;

import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * 同步发送消息
 *
 * @author yeyu
 * @since 2022/7/21 16:19
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException, UnsupportedEncodingException {
        DefaultMQProducer producer = new
                DefaultMQProducer("yy_test",
                new AclClientRPCHook(new SessionCredentials(
                        "eyJrZXlJZCI6InJvY2tldG1xLWU0N21wNDc1ZWp2ZSIsImFsZyI6IkhTMjU2In0.eyJzdWIiOiJyb2NrZXRtcS1lNDdtcDQ3NWVqdmVfYWRtaW4ifQ.yXB7VmaZNUhF2-IR_GJhNLIubuezYurzys6S6d7QbiU", "admin")));
        // Specify name server addresses.
        producer.setNamesrvAddr("rocketmq-e47mp475ejve.rocketmq.ap-sh.public.tencenttdmq.com:9876");
        producer.setNamespace("rocketmq-e47mp475ejve|daily");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 1; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("yy_test_topic" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
