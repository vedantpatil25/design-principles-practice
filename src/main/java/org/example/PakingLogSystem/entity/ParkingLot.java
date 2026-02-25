package org.example.PakingLogSystem.entity;

import org.example.PakingLogSystem.entity.slot.BikeSlot;
import org.example.PakingLogSystem.entity.slot.CarSlot;
import org.example.PakingLogSystem.entity.slot.Slot;
import org.example.PakingLogSystem.entity.slot.TruckSlot;

import java.util.*;

public class ParkingLot {
    private List<Slot> slotList;
    Map<Vehicle, Slot> vehicleSlotMap;

    Map<Vehicle, Ticket> vehicleTicketMap;
    List<Ticket> tickets;

    public ParkingLot() {
        slotList = new ArrayList<>();
        tickets = new ArrayList<>();
        vehicleSlotMap = new HashMap<>();
        vehicleTicketMap = new HashMap<>();
    }

    public boolean park(Vehicle vehicle) {
        if(vehicleSlotMap.containsKey(vehicle)) {
            throw new IllegalArgumentException("Vehicle already parked");
        }
        Slot slot = findAvailableSlot(vehicle).orElse(null);
        if (slot == null) {
            throw new IllegalArgumentException("Slot not found");
        }
        Ticket ticket = new Ticket(vehicle, slot);
        tickets.add(ticket);
        vehicleTicketMap.put(vehicle, ticket);

        slot.park(vehicle);
        vehicleSlotMap.put(vehicle, slot);

        return true;
    }

    private Optional<Slot> findAvailableSlot(Vehicle vehicle) {
        for (Slot slot : this.getSlotList()) {
            if(slot.isAvailable() && slot.canPark(vehicle)) {
                return Optional.of(slot);
            }
        }
        return Optional.empty();
    }

    public Ticket vacate(Vehicle vehicle) {
        if (!vehicleSlotMap.containsKey(vehicle)) {
            throw new IllegalArgumentException("Vehicle not found");
        }

        Slot slot = vehicleSlotMap.get(vehicle);
        slot.vacate();
        vehicleSlotMap.remove(vehicle);

        Ticket ticket = vehicleTicketMap.get(vehicle);
        vehicleTicketMap.remove(vehicle);

        return ticket;

    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


}
