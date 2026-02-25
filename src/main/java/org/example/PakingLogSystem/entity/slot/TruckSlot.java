package org.example.PakingLogSystem.entity.slot;

import org.example.PakingLogSystem.entity.Vehicle;
import org.example.PakingLogSystem.enums.VehicleType;

public class TruckSlot extends Slot {
    public TruckSlot(int id) {
        super(id);
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return vehicle.vehicleType == VehicleType.TRUCK;
    }

    @Override
    public int getHourlyRate() {
        return 30;
    }
}
