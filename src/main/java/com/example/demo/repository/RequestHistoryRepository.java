package com.example.demo.repository;

import com.example.demo.domain.entity.RequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RequestHistoryRepository extends JpaRepository<RequestHistory, UUID> {
    List<RequestHistory> findByRequestIdOrderByActionAtAsc(UUID requestId);
}
