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
@Table(name = "ram")
public class Ram extends BaseEntity {

    @Column(name = "size")
    private Integer size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    private TypeRam typeRam;

    @OneToMany(mappedBy = "idRam")
    private Set<Computer> computers = new LinkedHashSet<>();

}