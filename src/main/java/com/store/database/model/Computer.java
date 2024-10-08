package com.store.database.model;

import com.store.database.model.typesComponentsEntity.TypeComputer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_processor")
    private Processor idProcessor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motherboard")
    private Motherboard idMotherboard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_video_card")
    private VideoCard idVideoCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ram")
    private Ram idRam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cooler")
    private Cooler idCooler;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    private TypeComputer idType;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

}