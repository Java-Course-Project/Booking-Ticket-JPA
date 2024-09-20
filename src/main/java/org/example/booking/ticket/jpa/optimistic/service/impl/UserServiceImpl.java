package org.example.booking.ticket.jpa.optimistic.service.impl;

import org.example.booking.ticket.jpa.exception.DataInvalidException;
import org.example.booking.ticket.jpa.model.request.UserCreateRequest;
import org.example.booking.ticket.jpa.model.response.UserResponse;
import org.example.booking.ticket.jpa.optimistic.entity.Ticket;
import org.example.booking.ticket.jpa.optimistic.entity.TicketType;
import org.example.booking.ticket.jpa.optimistic.entity.User;
import org.example.booking.ticket.jpa.optimistic.repository.TicketRepository;
import org.example.booking.ticket.jpa.optimistic.repository.TicketTypeRepository;
import org.example.booking.ticket.jpa.optimistic.repository.UserRepository;
import org.example.booking.ticket.jpa.service.UserService;
import org.example.booking.ticket.jpa.utils.MapperFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final MapperFactory mapperFactory;

    public UserServiceImpl(TicketRepository ticketRepository, UserRepository userRepository, TicketTypeRepository ticketTypeRepository,
                           MapperFactory mapperFactory) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.ticketTypeRepository = ticketTypeRepository;
        this.mapperFactory = mapperFactory;
    }

    @Override
    public List<UserResponse> getUsers() {
        return mapperFactory.getMapper(User.class, UserResponse.class).map(userRepository.findAll());
    }

    @Override
    public void save(UserCreateRequest user) {
        userRepository.save(mapperFactory.getMapper(UserCreateRequest.class, User.class).map(user));
    }

    @Override
    public UserResponse getUserById(UUID id) {
        return mapperFactory.getMapper(User.class, UserResponse.class)
                            .map(userRepository.findById(id)
                                               .orElseThrow(() -> new DataInvalidException("User with id " + id + " not found")));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void buyTicket(UUID ticketId, UUID userId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                                        .orElseThrow(() -> new DataInvalidException("Ticket with id " + ticketId + " not found"));
        TicketType ticketType = ticketTypeRepository.findById(ticket.getTicketType().getId()).orElseThrow(
                () -> new DataInvalidException("Ticket type with id " + ticket.getTicketType().getId() + " not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new DataInvalidException("User with id " + userId + " not found"));
        if (user.getBalance().compareTo(ticketType.getPrice()) < 0) {
            throw new DataInvalidException("You have not enough money to buy this ticket");
        }
        if (ticket.getOwner() != null) {
            throw new DataInvalidException("Ticket already bought");
        }

        ticket.setOwner(user);
        user.setBalance(user.getBalance().subtract(ticketType.getPrice()));
        ticketRepository.save(ticket);
        userRepository.save(user);
    }
}
