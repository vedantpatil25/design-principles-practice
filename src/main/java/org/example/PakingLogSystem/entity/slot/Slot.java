package org.example.PakingLogSystem.entity.slot;

import org.example.PakingLogSystem.entity.Vehicle;

public abstract class Slot {
    public int id;
    public boolean occupied = false;
    public Vehicle vehicle;

    Slot(int id) {
        this.id = id;
    }

    public abstract boolean canPark(Vehicle vehicle);

    public void park(Vehicle vehicle) {
        if (!canPark(vehicle)) {
            throw new IllegalStateException("Can not park vehicle " + vehicle);        }
        occupied = true;
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return !occupied;
    }
    public void vacate() {
        occupied = false;
        vehicle = null;
    }

    public abstract int getHourlyRate();
}
