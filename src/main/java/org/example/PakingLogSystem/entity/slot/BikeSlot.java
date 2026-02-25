package org.example.PakingLogSystem.entity.slot;

import org.example.PakingLogSystem.entity.Vehicle;
import org.example.PakingLogSystem.enums.VehicleType;

public class BikeSlot extends Slot {

    public BikeSlot(int id) {
        super(id);
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return vehicle.vehicleType == VehicleType.BIKE;
    }

    @Override
    public int getHourlyRate() {
        return 10;
    }
}
