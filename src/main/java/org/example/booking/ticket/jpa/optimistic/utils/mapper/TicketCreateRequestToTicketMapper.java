package org.example.booking.ticket.jpa.optimistic.utils.mapper;

import org.example.booking.ticket.jpa.model.request.TicketCreateRequest;
import org.example.booking.ticket.jpa.optimistic.entity.Ticket;
import org.example.booking.ticket.jpa.optimistic.entity.TicketType;
import org.example.booking.ticket.jpa.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class TicketCreateRequestToTicketMapper implements Mapper<TicketCreateRequest, Ticket> {
    @Override
    public Ticket map(TicketCreateRequest ticketCreateRequest) {
        return Ticket.builder()
                     .row(ticketCreateRequest.getRow())
                     .seat(ticketCreateRequest.getSeat())
                     .section(ticketCreateRequest.getSection())
                     .startTime(ticketCreateRequest.getStartTime())
                     .ticketType(TicketType.builder().id(ticketCreateRequest.getTicketTypeId()).build())
                     .build();
    }

    @Override
    public Class<TicketCreateRequest> getSourceClass() {
        return TicketCreateRequest.class;
    }

    @Override
    public Class<Ticket> getDestinationClass() {
        return Ticket.class;
    }
}
