package org.example.booking.ticket.jpa.optimistic.utils.mapper;

import lombok.RequiredArgsConstructor;
import org.example.booking.ticket.jpa.model.response.TicketResponse;
import org.example.booking.ticket.jpa.optimistic.entity.Ticket;
import org.example.booking.ticket.jpa.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketToTicketResponseMapper implements Mapper<Ticket, TicketResponse> {
    private final TicketTypeToTicketTypeResponseMapper ticketTypeToTicketTypeResponseMapper;

    @Override
    public TicketResponse map(Ticket ticket) {
        return TicketResponse.builder()
                             .id(ticket.getId())
                             .row(ticket.getRow())
                             .seat(ticket.getSeat())
                             .section(ticket.getSection())
                             .startTime(ticket.getStartTime())
                             .isBooked(ticket.getOwner() != null)
                             .ticketType(ticketTypeToTicketTypeResponseMapper.map(ticket.getTicketType()))
                             .build();
    }

    @Override
    public Class<Ticket> getSourceClass() {
        return Ticket.class;
    }

    @Override
    public Class<TicketResponse> getDestinationClass() {
        return TicketResponse.class;
    }
}
