package com.example.TableBook.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable restaurantTable;
    LocalDate bookingDate;
    LocalTime startTime;
    LocalTime endTime;
    Integer guestsCount;
    @Enumerated(EnumType.STRING)
    BookingStatus status;
}
