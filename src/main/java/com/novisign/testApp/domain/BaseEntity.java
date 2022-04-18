package com.novisign.testApp.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private UUID id = UUID.randomUUID();

    @CreationTimestamp
    private Instant createdTime;

    @UpdateTimestamp
    private Instant updatedTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return getId().equals(that.getId()) && getCreatedTime().equals(that.getCreatedTime()) && getUpdatedTime().equals(that.getUpdatedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreatedTime(), getUpdatedTime());
    }
}
