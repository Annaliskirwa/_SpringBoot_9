package com.example.reddis_example.service.implementation;

import com.example.reddis_example.models.RedisModel;
import com.example.reddis_example.queue.RedisMessagePublisher;
import com.example.reddis_example.repository.ReddisRepository;
import com.example.reddis_example.service.ReddisService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ReddisServiceImpl implements ReddisService {
    @Autowired
    ReddisRepository reddisRepository;

    @Autowired
    RedisMessagePublisher redisMessagePublisher;
    @Override
    public ResponseEntity<?> storeData(RedisModel redisModel) {
        reddisRepository.save(redisModel);
        log.info("The data has been saved in the database {}", redisModel);

//        Reddis sending and receiving the messages
        Gson gson = new Gson();
        String message = gson.toJson(redisModel);
        redisMessagePublisher.publish(message);
        return ResponseEntity.ok(redisModel);
    }

    @Override
    public ResponseEntity<?> getData() {
        List<RedisModel> redisModels = new ArrayList<>();
        reddisRepository.findAll().forEach(redisModels::add);
        log.info("The data has been retrieved from the database {}", redisModels);
        return ResponseEntity.ok(redisModels);
    }
}
