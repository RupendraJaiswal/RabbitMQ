package com.springboot.component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MessageCache {

    private final Cache<String, String> messageCache;

    public MessageCache() {
        this.messageCache = CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(1000)
                .build();
    }

    public void put(String message) {
        messageCache.put(message, message);
    }

    public boolean contains(String message) {
        return messageCache.getIfPresent(message) != null;
    }
}
