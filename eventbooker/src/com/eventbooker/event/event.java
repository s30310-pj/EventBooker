package com.eventbooker.event;

import java.time.LocalDate;

public class event {
    private String name;
    private LocalDate dateTime;
    private String location;
    private int availableSeats;
    private double ticketPrice;

    public event(String name, LocalDate dateTime, String location, int availableSeats, double ticketPrice) {
        this.name = name;
        this.dateTime = dateTime;
        this.location = location;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "Event: " +
                "Name: " + name +
                ", Date:" + dateTime +
                ", Location: " + location +
                ", Available seats: " + availableSeats +
                ", Ticket price: " + ticketPrice;
    }

    public void setAvailableSeats(int availableSeats) {
        if (availableSeats < 0) {
            throw new IllegalArgumentException("Available seats cannot be negative");
        }
        this.availableSeats = availableSeats;
    }
}
