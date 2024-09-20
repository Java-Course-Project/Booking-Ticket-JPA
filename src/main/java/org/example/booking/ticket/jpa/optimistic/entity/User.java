package org.example.booking.ticket.jpa.optimistic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table
public class User extends VersionedEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Size(min = 2, max = 20)
    @Column(length = 20, nullable = false, unique = true)
    private String username;
    private LocalDate dob;
    // Use BigDecimal to avoid the floating problem with double
    @PositiveOrZero
    private BigDecimal balance;
    @OneToMany(mappedBy = "owner")
    private Set<Ticket> tickets;
}
