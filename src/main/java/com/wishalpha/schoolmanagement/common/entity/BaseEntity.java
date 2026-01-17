package com.wishalpha.schoolmanagement.common.entity;


import com.github.f4b6a3.uuid.UuidCreator;
import com.wishalpha.schoolmanagement.master.utils.AuditorAwareUtil;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.UUID;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    private final static Logger logger = LoggerFactory.getLogger(BaseEntity.class);

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @Column(updatable = false,nullable = false,unique = true)
    private UUID id;


    @Column(name = "created_by",updatable = false)
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }


    @PrePersist
    public void onCreate(){
        if(this.id == null){
            this.id = UuidCreator.getTimeOrderedEpoch();
        }

        UUID auditorId = AuditorAwareUtil.getCurrentAuditor();
        this.createdBy = auditorId;
        this.updatedBy = auditorId;
    }


    @PreUpdate
    public void onUpdate(){
        logger.info("Base Entity Run: -----------------------------------------");
        this.updatedBy = AuditorAwareUtil.getCurrentAuditor();
    }
}
