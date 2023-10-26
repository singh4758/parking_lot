import controllers.TicketController;
import models.Ticket;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

public class ParkingLotApplication {
  public static void main(String[] args) {
    GateRepository gateRepository = new GateRepository();
    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    TicketRepository ticketRepository = new TicketRepository();
    VehicleRepository vehicleRepository = new VehicleRepository();

    TicketService ticketService = new TicketService(
      gateRepository,
      vehicleRepository,
      parkingLotRepository,
      ticketRepository
    );

    TicketController ticketController = new TicketController(
      ticketService
    );


  }
}