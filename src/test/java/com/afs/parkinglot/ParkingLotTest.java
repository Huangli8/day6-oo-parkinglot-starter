package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_parking_ticket_when_given_car_parked(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot();
        ParkingTicket parkingTicket=parkingLot.park(car);
        assertNotNull(parkingTicket);
    }


}
