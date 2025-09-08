package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_parking_ticket_when_park_a_car(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot();
        ParkingTicket parkingTicket=parkingLot.park(car);
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_parked_car_when_fetch_a_car_given_parking_ticket(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot();
        ParkingTicket parkingTicket=parkingLot.park(car);
        assertEquals(car,parkingLot.fetch(parkingTicket));

    }

}
