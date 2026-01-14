package com.example.demo.domain.entity;

import java.time.Instant;
import java.util.UUID;

import com.example.demo.domain.enums.RequestStatus;
import com.example.demo.domain.enums.RequestType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "approval_requests")
public class ApprovalRequest {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "title", nullable = false, length = 120)
    private String title;

    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "requester_user", nullable = false, length = 80)
    private String requesterUser;

    @Column(name = "approver_user", nullable = false, length = 80)
    private String approverUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private RequestType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private RequestStatus status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public ApprovalRequest() {
        // JPA
    }

    // Getters & Setters (mínimo para que JPA/JSON funcionen)
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRequesterUser() { return requesterUser; }
    public void setRequesterUser(String requesterUser) { this.requesterUser = requesterUser; }

    public String getApproverUser() { return approverUser; }
    public void setApproverUser(String approverUser) { this.approverUser = approverUser; }

    public RequestType getType() { return type; }
    public void setType(RequestType type) { this.type = type; }

    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
