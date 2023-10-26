package repositories;

import models.Gate;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotRepository {
  private final HashMap<Long, ParkingLot> parkingLots = new HashMap<>();
  public Optional<ParkingLot> getParkingLotForGate(Gate gate) {
    for (ParkingLot parkingLot: parkingLots.values())
      if(parkingLot.getGates().contains(gate)) {
        return Optional.of(parkingLot);
      }
    return Optional.empty();
  }
}
