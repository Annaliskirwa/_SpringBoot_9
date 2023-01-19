package com.example.reddis_example.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BPR_NOTIFICATION")
@Data
public class ReddisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MESSAGE_ID")
    private String messageID;
    @Column(name="TRANSACTION_REFERENCE")
    private String transactionReference;
    @Column(name = "NOTIFICATION_TYPE")
    private String notificationType;
    @Column(name = "MESSAGE")
    private String message;
}
