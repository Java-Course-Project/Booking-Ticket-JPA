package org.example.booking.ticket.jpa.service;

import org.example.booking.ticket.jpa.model.request.TicketCreateRequest;
import org.example.booking.ticket.jpa.model.response.TicketResponse;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    List<TicketResponse> getTickets();

    TicketResponse getTicketById(UUID id);

    void save(TicketCreateRequest ticket);

    TicketResponse getTicketByLocation(long section, long seat, long row);
}
