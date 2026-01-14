package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entity.ApprovalRequest;
import com.example.demo.domain.enums.RequestStatus;

public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, UUID> {
    List<ApprovalRequest> findByApproverUserAndStatus(String approverUser, RequestStatus status);
}
