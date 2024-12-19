package com.example.demo.dto;

import com.example.demo.entity.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationRequestDto {
    private Long itemId;
    private Long userId;

    private Status status;

    private LocalDateTime startAt;

    private LocalDateTime endAt;
}
