package repositories;

import models.Gate;
import models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
  private final HashMap<String, Vehicle> vehicles = new HashMap<>();
  private int previousId = 0;
  public Optional<Vehicle> getVehicleByNumber(String number) {
    if(vehicles.containsKey(number)) {
      return Optional.ofNullable(vehicles.get(number));
    }
    return Optional.empty();
  }

  public Vehicle saveVehicle(Vehicle vehicle) {
    previousId += 1;
    vehicle.setId((long) previousId);
    vehicles.put(vehicle.getNumber(), vehicle);
    return vehicle;
  }
}
