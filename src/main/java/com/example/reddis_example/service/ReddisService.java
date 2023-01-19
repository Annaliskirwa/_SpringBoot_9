package com.example.reddis_example.service;

import com.example.reddis_example.models.RedisModel;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ReddisService {
    ResponseEntity<?> storeData(RedisModel redisModel);
    ResponseEntity<?> getData();
}
