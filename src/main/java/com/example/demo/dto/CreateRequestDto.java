package com.example.demo.dto;

import com.example.demo.domain.enums.RequestType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String requesterUser;

    @NotBlank
    private String approverUser;

    @NotNull
    private RequestType type;

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
}
