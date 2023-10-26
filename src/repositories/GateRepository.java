package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
  private final HashMap<Long, Gate> gate = new HashMap<>();
  public Optional<Gate> findGateById(Long id) {
    if(gate.containsKey(id)) {
      return Optional.ofNullable(gate.get(id));
    }
    return Optional.empty();
  }
}
