package services;

import Exceptions.GateNotFoundException;
import Exceptions.ParkingLotNotFoundException;
import Strategies.SlotAllotmentStartegy.SlotAllotmentStrategy;
import Strategies.SlotAllotmentStartegy.SlotAllotmentStrategyFactory;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
  private final GateRepository gateRepository;
  private final VehicleRepository vehicleRepository;
  private final ParkingLotRepository parkingLotRepository;
  private final TicketRepository ticketRepository;

  public TicketService(GateRepository gateRepository,
                       VehicleRepository vehicleRepository,
                       ParkingLotRepository parkingLotRepository,
                       TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
    this.vehicleRepository = vehicleRepository;
    this.gateRepository = gateRepository;
    this.parkingLotRepository = parkingLotRepository;
  }

  public Ticket issueTicket(VehicleType vehicleType,
                            String vehicleNumber,
                            String vehicleOwnerName,
                            Long gateId) throws GateNotFoundException, ParkingLotNotFoundException {
    Ticket ticket = new Ticket();
    ticket.setEntryTime(new Date());
    Optional<Gate> gate = gateRepository.findGateById(gateId);

    if (gate.isEmpty()) {
      throw new GateNotFoundException();
    }
    ticket.setGate(gate.get());
    ticket.setGeneratedBy(gate.get().getOperator());

    Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByNumber("shkhs");
    Vehicle vehicle;
    if (optionalVehicle.isEmpty()) {
      Vehicle newVehicle = new Vehicle();
      newVehicle.setVehicleType(vehicleType);
      newVehicle.setNumber(vehicleNumber);
      newVehicle.setOwnerName(vehicleOwnerName);
      vehicle = vehicleRepository.saveVehicle(newVehicle);
    } else {
      vehicle = optionalVehicle.get();
    }

    ticket.setVehicle(vehicle);

    Optional<ParkingLot> parkingLot =
      parkingLotRepository.getParkingLotForGate(gate.get());

    if(parkingLot.isEmpty()) {
      throw new ParkingLotNotFoundException();
    }

    SlotAllotmentStrategyType slotAllotmentStrategyType = parkingLot.get().getSlotAllotmentStrategyType();

    SlotAllotmentStrategy slotAllotmentStrategy = SlotAllotmentStrategyFactory
      .getSlotForType(slotAllotmentStrategyType);

    ticket.setParkingSlot(slotAllotmentStrategy.getSlot(gate.get(), vehicleType));

    ticket.setNumber("TICKET"+ticket.getId());

    return ticketRepository.saveTicket(ticket);
  }
}
