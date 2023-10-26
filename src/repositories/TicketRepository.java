package repositories;

import models.Gate;
import models.Ticket;

import java.util.HashMap;
import java.util.Optional;

public class TicketRepository {
  private final HashMap<Long, Ticket> tickets = new HashMap<>();
  private int previousId = 0;
  public Ticket saveTicket(Ticket ticket){
    previousId += 1;
    ticket.setId((long) previousId);
    tickets.put((long) previousId, ticket);
    return ticket;
  }
}
