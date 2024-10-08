package com.store.database.model;

import com.store.database.model.typesComponentsEntity.TypeCooler;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "coolers")
public class Cooler extends BaseEntity{

    @Column(name = "power")
    private Long power;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    private TypeCooler typeCooler;

    @OneToMany(mappedBy = "idCooler")
    private Set<Computer> computers = new HashSet<>();

}