package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int parkingCapacity = 10;
    private final Map<ParkingTicket,Car>parkedCars = new HashMap<>();
    public ParkingLot(){};
    public ParkingLot(int parkingCapacity){
        this.parkingCapacity=parkingCapacity;
    }
    public ParkingTicket park(Car car) {
        if (parkingCapacity == 0) {
            return null;
        }
        if(car.isParked()){
            return null;
        }
        car.setParked(true);
        ParkingTicket correctTicket = new ParkingTicket();
        parkedCars.put(correctTicket, car);
        parkingCapacity--;
        return correctTicket;
    }

    public Car fetch(ParkingTicket ticket) {
        if (ticket == null) {
            return null;
        }
        if (ticket.isUsed()) {
            return null;
        }
        if (!parkedCars.containsKey(ticket)) {
            return null;
        }
        Car car = parkedCars.get(ticket);
        car.setParked(false);
        parkedCars.remove(ticket);
        ticket.setUsed(true);
        parkingCapacity++;
        return car;
    }

}
