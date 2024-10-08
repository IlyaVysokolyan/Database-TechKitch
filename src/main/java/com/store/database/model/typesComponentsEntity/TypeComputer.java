package com.store.database.model.typesComponentsEntity;

import com.store.database.model.Computer;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "type_computers")
public class TypeComputer extends AbstractTypeEntity {

    @OneToMany(mappedBy = "idType")
    private Set<Computer> computers = new HashSet<>();

}