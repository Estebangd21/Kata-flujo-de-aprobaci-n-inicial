package com.example.demo.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.ApprovalRequest;
import com.example.demo.domain.entity.RequestHistory;
import com.example.demo.domain.enums.RequestStatus;
import com.example.demo.dto.CreateRequestDto;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.repository.RequestHistoryRepository;



@Service
public class ApprovalRequestService {

    private final ApprovalRequestRepository requestRepository;
    private final RequestHistoryRepository historyRepository;

    public ApprovalRequestService(ApprovalRequestRepository requestRepository,
                                  RequestHistoryRepository historyRepository) {
        this.requestRepository = requestRepository;
        this.historyRepository = historyRepository;
    }

    public ApprovalRequest create(CreateRequestDto dto) {
        Instant now = Instant.now();

        ApprovalRequest req = new ApprovalRequest();
        req.setId(UUID.randomUUID());
        req.setTitle(dto.getTitle());
        req.setDescription(dto.getDescription());
        req.setRequesterUser(dto.getRequesterUser());
        req.setApproverUser(dto.getApproverUser());
        req.setType(dto.getType());
        req.setStatus(RequestStatus.PENDING);
        req.setCreatedAt(now);
        req.setUpdatedAt(now);

        ApprovalRequest saved = requestRepository.save(req);

        // histórico inicial (creación)
        RequestHistory h = new RequestHistory();
        h.setId(UUID.randomUUID());
        h.setRequestId(saved.getId());
        h.setFromStatus(null);
        h.setToStatus(RequestStatus.PENDING);
        h.setActionBy(dto.getRequesterUser());
        h.setComment("Request created");
        h.setActionAt(now);

        historyRepository.save(h);

        return saved;
    }
    
    public List<ApprovalRequest> findByApproverAndStatus(String approverUser, RequestStatus status) {
    return requestRepository.findByApproverUserAndStatus(approverUser, status);
}
    public List<ApprovalRequest> findAll() {
    return requestRepository.findAll();
}


}
