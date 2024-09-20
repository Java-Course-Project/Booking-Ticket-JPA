package org.example.booking.ticket.jpa.optimistic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"section", "seat", "row"})})
public class Ticket extends VersionedEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private int section;
    private int seat;
    private int row;
    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "owner_id")
    private User owner;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ticket_type_id")
    private TicketType ticketType;
}
