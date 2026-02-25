package org.example.PakingLogSystem.entity.slot;

import org.example.PakingLogSystem.entity.Vehicle;
import org.example.PakingLogSystem.enums.VehicleType;

public class CarSlot extends Slot {

    public CarSlot(int id) {
        super(id);
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return vehicle.vehicleType == VehicleType.CAR;
    }

    @Override
    public int getHourlyRate() {
        return 20;
    }
}
