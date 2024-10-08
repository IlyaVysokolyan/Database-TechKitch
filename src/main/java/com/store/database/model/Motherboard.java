package com.store.database.model;

import com.store.database.model.typesComponentsEntity.TypeRam;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "motherboards")
public class Motherboard extends BaseEntity {

    @Column(name = "socket")
    private String socket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_memory")
    private TypeRam typeRam;

    @OneToMany(mappedBy = "idMotherboard")
    private Set<Computer> computers = new LinkedHashSet<>();

}