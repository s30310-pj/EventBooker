package com.eventbooker.booking;

import com.eventbooker.event.event;
import com.eventbooker.user.user;

import java.util.ArrayList;
import java.util.List;

public class bookingmanager {
    private List<booking> bookings = new ArrayList<>();

    public void bookTicket(user user, event event, int seatNumber) {
        booking booking = new booking(user, event, seatNumber);
        bookings.add(booking);
        event.setAvailableSeats(event.getAvailableSeats() - 1);
    }
}
