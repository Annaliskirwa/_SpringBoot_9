package com.example.reddis_example.controller;

import com.example.reddis_example.models.RedisModel;
import com.example.reddis_example.service.ReddisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class ReddisController {
    @Autowired
    ReddisService reddisService;
    @PostMapping(value = "post-notification")
    public ResponseEntity<?> storeData(@RequestBody RedisModel redisModel){
    return reddisService.storeData(redisModel);
    }
    @GetMapping(value = "get-notification")
    public ResponseEntity<?> getData(){
        return reddisService.getData();
    }
}
