package com.store.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "video_cards")
public class VideoCard extends BaseEntity {

    @Column(name = "size_memory")
    private Integer sizeMemory;

    @OneToMany(mappedBy = "idVideoCard")
    private Set<Computer> computers = new LinkedHashSet<>();



}