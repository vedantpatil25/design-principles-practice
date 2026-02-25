package org.example.PakingLogSystem.entity;

import org.example.PakingLogSystem.entity.slot.Slot;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Vehicle vehicle;
    private Slot slot;
    public long charges = 0;

    Ticket(Vehicle vehicle, Slot slot) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    public long calculateCost() {
        this.exitTime = LocalDateTime.now();
        long hours =  Duration.between(entryTime, exitTime).toHours();
        int hourlyRate = slot.getHourlyRate();

        return charges = (hours * hourlyRate);
    }

    public String printTicket() {
        String curr =  "Vehicle: {" + vehicle.vehicleId + ", "  + vehicle.vehicleType + "} \nSlot: " + slot.id + " \nEntry: " + entryTime + ", Exit: " + exitTime + ", Charges: " + charges;
        System.out.println("============ TICKET ============");
        System.out.println(curr);
        System.out.println("============ END ============");
        return curr;
    }


}
