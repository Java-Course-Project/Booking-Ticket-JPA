package org.example.booking.ticket.jpa.service;

import org.example.booking.ticket.jpa.model.request.UserCreateRequest;
import org.example.booking.ticket.jpa.model.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse> getUsers();

    void save(UserCreateRequest user);

    UserResponse getUserById(UUID id);

    void buyTicket(UUID ticketId, UUID userId);
}
