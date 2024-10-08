package com.store.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "processors")
public class Processor extends BaseEntity {

    @Column(name = "socket")
    private String socket;

    @OneToMany(mappedBy = "idProcessor")
    private Set<Computer> computers = new LinkedHashSet<>();

}