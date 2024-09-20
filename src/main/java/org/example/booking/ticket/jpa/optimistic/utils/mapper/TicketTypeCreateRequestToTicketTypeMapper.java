package org.example.booking.ticket.jpa.optimistic.utils.mapper;


import lombok.RequiredArgsConstructor;
import org.example.booking.ticket.jpa.model.request.TicketTypeCreateRequest;
import org.example.booking.ticket.jpa.optimistic.entity.TicketType;
import org.example.booking.ticket.jpa.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketTypeCreateRequestToTicketTypeMapper implements Mapper<TicketTypeCreateRequest, TicketType> {

    @Override
    public TicketType map(TicketTypeCreateRequest ticketTypeCreateRequest) {
        return TicketType.builder()
                         .event(ticketTypeCreateRequest.getEvent())
                         .type(ticketTypeCreateRequest.getType())
                         .price(ticketTypeCreateRequest.getPrice())
                         .build();
    }

    @Override
    public Class<TicketTypeCreateRequest> getSourceClass() {
        return TicketTypeCreateRequest.class;
    }

    @Override
    public Class<TicketType> getDestinationClass() {
        return TicketType.class;
    }
}
