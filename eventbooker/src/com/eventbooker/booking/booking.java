package com.eventbooker.booking;

import com.eventbooker.event.event;
import com.eventbooker.user.user;

public class booking {
    private user user;
    private event event;
    private int seatNumber;

    public booking(user user, event event, int seatNumber) {
        this.user = user;
        this.event = event;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user.getUsername() +
                ", event=" + event.getName() +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
