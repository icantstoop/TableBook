package com.example.TableBook.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class BookingRequest {
    @NotNull
    Long tableId;
    @NotNull
    LocalDate bookingDate;
    @NotNull
    LocalTime startTime;
    @NotNull
    LocalTime endTime;
    @Min(1)
    @NotNull
    Integer guestsCount;
    @NotNull
    Long userId;
}
