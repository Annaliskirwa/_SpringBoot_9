package com.example.reddis_example.queue;

import com.example.reddis_example.models.RedisModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RedisMessageSubscriber implements MessageListener {
    public static List<String> messageList = new ArrayList<String>();


    public void onMessage(Message message, final byte[] pattern) {
//        Gson gson = new Gson();
//        String notification = gson.toJson(redisModelList);
        messageList.add(message.toString());
        log.info("Message received: {}", message.getBody());
    }
}
