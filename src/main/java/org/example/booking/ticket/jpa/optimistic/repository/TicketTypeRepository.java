package org.example.booking.ticket.jpa.optimistic.repository;

import org.example.booking.ticket.jpa.optimistic.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketTypeRepository extends JpaRepository<TicketType, UUID> {
}
