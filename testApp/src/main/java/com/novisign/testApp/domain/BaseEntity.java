package com.novisign.testApp.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.IDENTITY)
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false, unique = true, updatable = false)
    private UUID id;

    @CreationTimestamp
    protected LocalDate createdTime;

    @UpdateTimestamp
    protected LocalTime updatedTime;

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
