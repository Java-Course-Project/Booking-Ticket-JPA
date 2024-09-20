package org.example.booking.ticket.jpa.optimistic.utils.mapper;

import org.example.booking.ticket.jpa.model.response.TicketTypeResponse;
import org.example.booking.ticket.jpa.optimistic.entity.TicketType;
import org.example.booking.ticket.jpa.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class TicketTypeToTicketTypeResponseMapper implements Mapper<TicketType, TicketTypeResponse> {
    @Override
    public TicketTypeResponse map(TicketType ticketType) {
        return TicketTypeResponse.builder()
                                 .id(ticketType.getId())
                                 .event(ticketType.getEvent())
                                 .type(ticketType.getType())
                                 .price(ticketType.getPrice())
                                 .build();
    }

    @Override
    public Class<TicketType> getSourceClass() {
        return TicketType.class;
    }

    @Override
    public Class<TicketTypeResponse> getDestinationClass() {
        return TicketTypeResponse.class;
    }
}
