package controllers;

import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import dtos.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
  private TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO){
    Ticket ticket;
    IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();
    try {
      ticket = ticketService.issueTicket(
        requestDTO.getVehicleType(),
        requestDTO.getVehicleNumber(),
        requestDTO.getVehicleOwnerName(),
        requestDTO.getGateId());
    } catch (Exception err) {
      issueTicketResponseDTO.setResponseStatus(ResponseStatus.ERROR);
      issueTicketResponseDTO.setErrorMessage(err.getMessage());
      return issueTicketResponseDTO;
    }

    issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
    issueTicketResponseDTO.setTicket(ticket);
    return issueTicketResponseDTO;
  }
}
