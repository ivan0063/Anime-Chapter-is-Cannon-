package com.ivan0063.magi.animechapters.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SERIES")
@Data
public class Series implements Serializable {
    @Id
    @Column(name = "ID_SERIES")
    private Integer idSerie;

    @Column(name = "TITLE")
    private String title;
}
