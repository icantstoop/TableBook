package com.example.TableBook.repository;

import com.example.TableBook.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.restaurantTable.id = :tableId " +
            "AND b.bookingDate = :date " +
            "AND b.status != 'CANCELLED' " +
            "AND b.startTime < :endTime AND b.endTime > :startTime")
    List<Booking> findOverlappingBookings(
            @Param("tableId") Long tableId,
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );
}
