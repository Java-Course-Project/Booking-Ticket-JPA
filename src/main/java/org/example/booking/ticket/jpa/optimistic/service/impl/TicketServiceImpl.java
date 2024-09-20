package org.example.booking.ticket.jpa.optimistic.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.booking.ticket.jpa.exception.DataInvalidException;
import org.example.booking.ticket.jpa.model.request.TicketCreateRequest;
import org.example.booking.ticket.jpa.model.response.TicketResponse;
import org.example.booking.ticket.jpa.optimistic.entity.Ticket;
import org.example.booking.ticket.jpa.optimistic.repository.TicketRepository;
import org.example.booking.ticket.jpa.service.TicketService;
import org.example.booking.ticket.jpa.utils.MapperFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final MapperFactory mapperFactory;

    @Override
    public List<TicketResponse> getTickets() {
        return mapperFactory.getMapper(Ticket.class, TicketResponse.class).map(ticketRepository.findAll());
    }

    @Override
    public TicketResponse getTicketById(UUID id) {
        return mapperFactory.getMapper(Ticket.class, TicketResponse.class)
                            .map(ticketRepository.findById(id)
                                                 .orElseThrow(() -> new DataInvalidException("Ticket with id " + id + " not found")));
    }

    @Override
    public void save(TicketCreateRequest ticket) {
        ticketRepository.save(mapperFactory.getMapper(TicketCreateRequest.class, Ticket.class).map(ticket));
    }

    @Override
    public TicketResponse getTicketByLocation(long section, long seat, long row) {
        return mapperFactory.getMapper(Ticket.class, TicketResponse.class).map(ticketRepository.findByLocation(section, seat, row));
    }
}
