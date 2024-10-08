package com.store.database.model.typesComponentsEntity;

import com.store.database.model.Ram;
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
@Table(name = "type_ram")
public class TypeRam extends AbstractTypeEntity {

    @OneToMany(mappedBy = "typeRam")
    private Set<Ram> rams = new HashSet<>();

}