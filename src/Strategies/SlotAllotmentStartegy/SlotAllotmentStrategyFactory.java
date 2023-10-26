package Strategies.SlotAllotmentStartegy;

import models.Gate;
import models.ParkingSlot;
import models.SlotAllotmentStrategyType;
import models.VehicleType;

public class SlotAllotmentStrategyFactory {
  public static SlotAllotmentStrategy getSlotForType(SlotAllotmentStrategyType slotAllotmentStrategyType) {
    return new RandomSlotAllotmentStrategy();
  }
}
