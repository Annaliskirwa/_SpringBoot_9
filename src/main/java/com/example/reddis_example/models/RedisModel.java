package com.example.reddis_example.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Data
@RedisHash("Notification")
public class RedisModel implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;
    @Id
    @SequenceGenerator(name = "NOTIF_GEN", sequenceName = "NOTIF", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIF_GEN")
    private Long id;
    private String messageID;
    private String transactionReference;
    private String notificationType;
    private String message;
}
