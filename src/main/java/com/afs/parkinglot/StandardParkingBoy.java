package com.afs.parkinglot;

public class StandardParkingBoy {
    ParkingLot parkingLot;
    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLot=parkingLot;
    }
    public ParkingTicket park(Car car){
        return parkingLot.park(car);
    }
    public Car fetch(ParkingTicket ticket){
        return parkingLot.fetch(ticket);
    }

}
