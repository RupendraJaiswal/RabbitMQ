package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.MessageLog;

public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
