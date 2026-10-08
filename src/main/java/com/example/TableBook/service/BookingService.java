package com.example.TableBook.service;

import com.example.TableBook.dto.BookingRequest;
import com.example.TableBook.dto.BookingResponse;
import com.example.TableBook.dto.RestaurantResponse;

public interface BookingService {
    BookingResponse create(BookingRequest request);
}
