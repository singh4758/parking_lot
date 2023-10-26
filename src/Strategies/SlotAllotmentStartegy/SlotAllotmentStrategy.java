package Strategies.SlotAllotmentStartegy;

import models.Gate;
import models.ParkingSlot;
import models.VehicleType;

public interface SlotAllotmentStrategy {
  public ParkingSlot getSlot(Gate gate, VehicleType vehicleType);
}
