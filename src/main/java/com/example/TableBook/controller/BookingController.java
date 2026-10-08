package com.example.TableBook.controller;

import com.example.TableBook.dto.BookingRequest;
import com.example.TableBook.dto.BookingResponse;
import com.example.TableBook.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping(value = "/api/v1/bookings")
    public ResponseEntity<BookingResponse> create(@Valid @RequestBody BookingRequest request){
        BookingResponse book = bookingService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

}
