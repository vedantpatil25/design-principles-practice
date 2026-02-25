package org.example.PakingLogSystem.service;

import org.example.PakingLogSystem.entity.ParkingLot;
import org.example.PakingLogSystem.entity.Ticket;
import org.example.PakingLogSystem.entity.Vehicle;
import org.example.PakingLogSystem.entity.slot.Slot;

import java.util.Optional;

public class ParkingLotService {

    public boolean makeVehicleEntry(Vehicle vehicle, ParkingLot parkingLot) {
        return parkingLot.park(vehicle);
    }

    public boolean exitVehicle(Vehicle vehicle, ParkingLot parkingLot, PaymentStrategy paymentStrategy) {
        Ticket ticket = parkingLot.vacate(vehicle);
        long charges = ticket.calculateCost();
        ticket.printTicket();
        return paymentStrategy.pay(charges);
    }



}
