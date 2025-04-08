package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.MessageLog;
import com.springboot.repository.MessageLogRepository;
import com.springboot.service.MessageProducer;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageProducer producer;
    

    @Autowired
    private MessageLogRepository messageLogRepository;

    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        producer.sendMessage(message);
        // Save to MySQL
        MessageLog log = new MessageLog();
        log.setMessage(message);
        messageLogRepository.save(log);

        return ResponseEntity.ok("Message sent: " + message);
    }
}
