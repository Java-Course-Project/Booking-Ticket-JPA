package org.example.booking.ticket.jpa.optimistic.repository;

import org.example.booking.ticket.jpa.optimistic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
