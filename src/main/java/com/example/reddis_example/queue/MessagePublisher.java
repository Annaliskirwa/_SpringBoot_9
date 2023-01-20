package com.example.reddis_example.queue;

public interface MessagePublisher {
    void publish(final String message);
}
