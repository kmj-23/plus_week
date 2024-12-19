package com.example.demo.controller;

import com.example.demo.dto.ReservationRequestDto;

import com.example.demo.entity.Status;
import com.example.demo.service.ReservationService;
import com.example.demo.util.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void createReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        reservationService.createReservation(reservationRequestDto.getItemId(),
                                            reservationRequestDto.getUserId(),
                                            reservationRequestDto.getStartAt(),
                                            reservationRequestDto.getEndAt());
    }

    @PatchMapping("/{id}/update-status")
    public ResponseEntity<CommonResponse<Void>> updateReservation(@PathVariable Long id, @RequestBody ReservationRequestDto reservationRequestDto) {
        reservationService.updateReservationStatus(id, reservationRequestDto.getStatus());
        return new ResponseEntity<>(new CommonResponse<>(reservationRequestDto.getStatus() + "처리가 완료되었습니다."), HttpStatus.OK);
    }

    @GetMapping
    public void findAll() {
        reservationService.getReservations();
    }

    @GetMapping("/search")
    public void searchAll(@RequestParam(required = false) Long userId,
                          @RequestParam(required = false) Long itemId) {
        reservationService.searchAndConvertReservations(userId, itemId);
    }
}
