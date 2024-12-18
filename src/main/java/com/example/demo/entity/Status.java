package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum Status {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    CANCELED("CANCELED"),
    EXPIRED("EXPIRED");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }
    public static Status status(String statusName) {
        for (Status status : values()) {
            if (status.getStatusName().equals(statusName)) {
                return status;
            }
        }

        throw new IllegalArgumentException("올바르지 않은 상태: " + statusName);
    }

}
