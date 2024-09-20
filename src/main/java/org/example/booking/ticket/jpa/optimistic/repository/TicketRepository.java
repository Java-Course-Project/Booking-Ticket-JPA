package org.example.booking.ticket.jpa.optimistic.repository;

import org.example.booking.ticket.jpa.optimistic.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    @Query(value = "SELECT t FROM Ticket t WHERE t.seat = :seat AND t.section = :section AND t.row = :row")
    Ticket findByLocation(long section, long seat, long row);
}
