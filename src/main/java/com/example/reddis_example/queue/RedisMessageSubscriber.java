package com.example.reddis_example.queue;

import com.example.reddis_example.models.RedisModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RedisMessageSubscriber implements MessageListener {
    public static List<String> messageList = new ArrayList<String>();

    public void onMessage(Message message, final byte[] pattern) {
        messageList.add(message.toString());
        log.info("Message received: {}", message);
        checkIfMessageReceived(message);
    }

    public void checkIfMessageReceived(Message message){
//        TODO Springboot returns special characters from redis cache, clean it
        log.info("See the data type {}",RedisMessageSubscriber. messageList.get(0)
                .replaceAll("[^a-zA-Z0-9\"{}:,]", "").
                replaceFirst("t",""));
        Gson gson = new Gson();
        String message1 = RedisMessageSubscriber. messageList.get(0)
                .replaceAll("[^a-zA-Z0-9\"{}:,]", "").
                replaceFirst("t","");
        RedisModel redisModel = gson.fromJson(message1, RedisModel.class);

        log.info("The transaction reference is: {}", redisModel.getTransactionReference());
    }
}



