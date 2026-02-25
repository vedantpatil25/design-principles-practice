package org.example.PakingLogSystem;

import org.example.PakingLogSystem.entity.ParkingLot;
import org.example.PakingLogSystem.entity.Vehicle;
import org.example.PakingLogSystem.entity.slot.BikeSlot;
import org.example.PakingLogSystem.entity.slot.CarSlot;
import org.example.PakingLogSystem.entity.slot.Slot;
import org.example.PakingLogSystem.entity.slot.TruckSlot;
import org.example.PakingLogSystem.enums.VehicleType;
import org.example.PakingLogSystem.service.CashPaymentStrategy;
import org.example.PakingLogSystem.service.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        ParkingLot parkingLot = new ParkingLot();
        addDefaultSlots(parkingLot);

        Vehicle vehicle = new Vehicle("1", VehicleType.BIKE);
        Vehicle vehicle1 = new Vehicle("2", VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("3", VehicleType.TRUCK);


        parkingLotService.makeVehicleEntry(vehicle, parkingLot);
        parkingLotService.exitVehicle(vehicle, parkingLot, new CashPaymentStrategy());

        parkingLotService.makeVehicleEntry(vehicle1, parkingLot);
        parkingLotService.exitVehicle(vehicle1, parkingLot, new CashPaymentStrategy());

        parkingLotService.makeVehicleEntry(vehicle2, parkingLot);
        parkingLotService.exitVehicle(vehicle2, parkingLot, new CashPaymentStrategy());
    }

    private static void addDefaultSlots(ParkingLot parkingLot) {
        List<Slot> slotList = parkingLot.getSlotList();
        slotList.add(new BikeSlot(1));
        slotList.add(new BikeSlot(2));
        slotList.add(new BikeSlot(3));

        slotList.add(new CarSlot(4));
        slotList.add(new CarSlot(5));
        slotList.add(new CarSlot(6));

        slotList.add(new TruckSlot(7));
        slotList.add(new TruckSlot(8));
        slotList.add(new TruckSlot(9));
    }
}
