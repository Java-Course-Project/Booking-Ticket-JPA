package org.example.booking.ticket.jpa.optimistic.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class VersionedEntity {
    @Version
    private int version;
}
