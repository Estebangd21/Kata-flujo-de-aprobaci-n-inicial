package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.ApprovalRequest;
import com.example.demo.domain.enums.RequestStatus;
import com.example.demo.dto.CreateRequestDto;
import com.example.demo.service.ApprovalRequestService;


@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApprovalRequest create(@RequestBody CreateRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ApprovalRequest> getRequests(
        @RequestParam(required = false) String approverUser,
        @RequestParam(required = false) RequestStatus status
    ) {
    if (approverUser != null && status != null) {
        return service.findByApproverAndStatus(approverUser, status);
    }
    return service.findAll();
}
}