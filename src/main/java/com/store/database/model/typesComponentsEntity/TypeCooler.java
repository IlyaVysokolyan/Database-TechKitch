package com.store.database.model.typesComponentsEntity;

import com.store.database.model.Cooler;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "type_cooler")
public class TypeCooler extends AbstractTypeEntity {

    @OneToMany(mappedBy = "typeCooler")
    private Set<Cooler> coolers = new HashSet<>();

}