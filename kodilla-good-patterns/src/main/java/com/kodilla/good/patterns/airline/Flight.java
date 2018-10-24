package com.kodilla.good.patterns.airline;

import java.time.LocalTime;
import java.util.Objects;

public class Flight {
    private final String departureAirport;
    private final String arrivalAirport;
    private final LocalTime departureTime;
    private final LocalTime arrivalTime;

    public Flight(String departureAirport, String arrivalAirport, LocalTime departureTime, LocalTime arrivalTime) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(arrivalAirport, flight.arrivalAirport) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(arrivalTime, flight.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, arrivalAirport, departureTime, arrivalTime);
    }

    @Override
    public String toString() {
        return "Flight:\n" +
                "departureAirport = '" + departureAirport + '\'' +
                ", arrivalAirport = '" + arrivalAirport + '\'' +
                ", departureTime = " + departureTime +
                ", arrivalTime = " + arrivalTime;
    }
}
