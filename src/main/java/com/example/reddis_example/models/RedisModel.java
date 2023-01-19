package com.example.reddis_example.models;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Notification")
public class RedisModel{
    private int id;
    private String messageID;
    private String transactionReference;
    private String notificationType;
    private String message;
}
