package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_correct_car_each_time_when_fetch_cars_given_two_cars_and_two_tickets(){
        Car car1=new Car();
        Car car2=new Car();
        ParkingLot parkingLot=new ParkingLot();
        ParkingTicket parkingTicket1=parkingLot.park(car1);
        ParkingTicket parkingTicket2=parkingLot.park(car2);
        assertEquals(car1,parkingLot.fetch(parkingTicket1));
        assertEquals(car2,parkingLot.fetch(parkingTicket2));
    }

    @Test
    void should_return_nothing_when_fetch_a_car_given_no_ticket() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);
        assertNull(parkingLot.fetch(null));
    }

//    @Test
//    void should_return_nothing_when_fetch_a_car_given_wrong_ticket(){
//        Car car=new Car();
//        ParkingLot parkingLot=new ParkingLot();
//        ParkingTicket correctTicket=parkingLot.park(car);
//        ParkingTicket wrongTicket = new ParkingTicket();
//        assertNull(parkingLot.fetch(wrongTicket));
//    }
//
//    @Test
//    void should_return_nothing_when_fetch_a_car_given_used_ticket() {
//        Car car = new Car();
//        ParkingLot parkingLot = new ParkingLot();
//        ParkingTicket parkingTicket = parkingLot.park(car);
//        parkingLot.fetch(parkingTicket);
//        assertNull(parkingLot.fetch(parkingTicket));
//    }
    @Test
    void should_throw_unrecognized_parking_ticket_when_fetch_car_given_unrecognized_ticket() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(car);

        ParkingTicket wrongTicket = new ParkingTicket();

        UnrecognizedParkingTicketException ex = assertThrows(
                UnrecognizedParkingTicketException.class,
                () -> parkingLot.fetch(wrongTicket)
        );
        assertEquals("Unrecognized parking ticket.", ex.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_when_fetch_car_given_used_ticket() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingTicket ticket = parkingLot.park(car);

        Car fetched = parkingLot.fetch(ticket);
        assertEquals(car, fetched);

        UnrecognizedParkingTicketException ex = assertThrows(
                UnrecognizedParkingTicketException.class,
                () -> parkingLot.fetch(ticket)
        );
        assertEquals("Unrecognized parking ticket.", ex.getMessage());
    }

    @Test
    void should_throw_no_available_position_when_park_car_given_no_available_position() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(0);

        NoAvailablePositionException ex = assertThrows(
                NoAvailablePositionException.class,
                () -> parkingLot.park(car)
        );
        assertEquals("No available position.", ex.getMessage());
    }

    @Test
    void should_return_parking_ticket_when_park_car_given_parking_lot_and_standard_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        ParkingTicket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_return_parked_car_when_fetch_car_given_valid_ticket_and_standard_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        ParkingTicket ticket = parkingBoy.park(car);
        assertEquals(car, parkingBoy.fetch(ticket));
    }

    @Test
    void should_return_right_car_each_time_when_fetch_twice_given_two_cars_two_tickets_and_standard_parking_boy() {
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        ParkingTicket ticket1 = parkingBoy.park(car1);
        ParkingTicket ticket2 = parkingBoy.park(car2);

        assertEquals(car1, parkingBoy.fetch(ticket1));
        assertEquals(car2, parkingBoy.fetch(ticket2));
    }

    @Test
    void should_throw_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket_and_standard_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        standardParkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();
        UnrecognizedParkingTicketException ex = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(wrongTicket));
        assertEquals("Unrecognized parking ticket.", ex.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_when_fetch_car_given_used_ticket_and_standard_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        ParkingTicket ticket = standardParkingBoy.park(car);
        Car fetchCar = standardParkingBoy.fetch(ticket);
        assertEquals(car, fetchCar);

        UnrecognizedParkingTicketException ex = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", ex.getMessage());
    }
    @Test
    void should_throw_no_available_position_when_park_car_given_no_available_position_and_standard_parking_boy() {
        ParkingLot lot = new ParkingLot(0);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(lot);
        Car car = new Car();

        NoAvailablePositionException ex = assertThrows(
                NoAvailablePositionException.class,
                () -> standardParkingBoy.park(car)
        );
        assertEquals("No available position.", ex.getMessage());
    }
}
