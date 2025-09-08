package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int parkingCapacity = 10;
    private final Map<Ticket,Car>parkedCars = new HashMap<>();

    public Ticket park(Car car) {
        if (parkingCapacity == 0) {
            System.out.println("停车场已满");
            return null;
        }
        if(car.isParked()){
            System.out.println("车已停过");
            return null;
        }
        car.setParked(true);
        Ticket correctTicket = new Ticket();
        parkedCars.put(correctTicket, car);
        parkingCapacity--;
        return correctTicket;
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) {
            return null;
        }
        if (ticket.isUsed()) {
            System.out.println("票已用过");
            return null;
        }
        if (!parkedCars.containsKey(ticket)) {
            System.out.println("不是正确的票");
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
