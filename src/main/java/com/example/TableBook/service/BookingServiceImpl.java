package com.example.TableBook.service;

import com.example.TableBook.dto.BookingRequest;
import com.example.TableBook.dto.BookingResponse;
import com.example.TableBook.entity.Booking;
import com.example.TableBook.entity.BookingStatus;
import com.example.TableBook.entity.RestaurantTable;
import com.example.TableBook.entity.User;
import com.example.TableBook.exception.BookingConflictException;
import com.example.TableBook.exception.InvalidBookingTimeException;
import com.example.TableBook.exception.RestaurantNotFoundException;
import com.example.TableBook.repository.BookingRepository;
import com.example.TableBook.repository.RestaurantTableRepository;
import com.example.TableBook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RestaurantTableRepository restaurantTableRepository;

    @Override
    public BookingResponse create(BookingRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RestaurantNotFoundException("User not found with id: " + request.getUserId()));

        RestaurantTable table = restaurantTableRepository.findById(request.getTableId())
                .orElseThrow(() -> new RestaurantNotFoundException("Table not found with id: " + request.getTableId()));

        if (!request.getEndTime().isAfter(request.getStartTime())){
            throw new InvalidBookingTimeException("End time must be after start time");
        }

        List<Booking> overlapping = bookingRepository.findOverlappingBookings(
                request.getTableId(),
                request.getBookingDate(),
                request.getStartTime(),
                request.getEndTime()
        );

        if (!overlapping.isEmpty()){
            throw new BookingConflictException("Table is already booked for this time");
        }

        Booking booking = Booking.builder()
                .user(user)
                .restaurantTable(table)
                .bookingDate(request.getBookingDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .guestsCount(request.getGuestsCount())
                .status(BookingStatus.PENDING)
                .build();

        Booking saved = bookingRepository.save(booking);
        return mapToResponse(saved);

    }

    private BookingResponse mapToResponse(Booking booking){
        return BookingResponse.builder()
                .id(booking.getId())
                .bookingDate(booking.getBookingDate())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .guestsCount(booking.getGuestsCount())
                .status(booking.getStatus())
                .username(booking.getUser().getUsername())
                .tableNumber(booking.getRestaurantTable().getTableNumber())
                .build();
    }

}
