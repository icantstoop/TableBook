package com.example.TableBook.dto;

import com.example.TableBook.entity.BookingStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class BookingResponse {
    Long id;
    LocalDate bookingDate;
    LocalTime startTime;
    LocalTime endTime;
    Integer guestsCount;
    BookingStatus status;
    String username;
    Integer tableNumber;
}
