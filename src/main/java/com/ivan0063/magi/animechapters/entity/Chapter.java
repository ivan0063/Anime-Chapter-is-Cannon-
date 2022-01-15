package com.ivan0063.magi.animechapters.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "CHAPTERS")
@Entity
@Data
public class Chapter implements Serializable {
    @Id
    @Column(name = "CHAPTER_NO")
    private Integer chapterNo;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "STATUS")
    private String status;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SERIES", nullable = false)
    private Series SERIE;
}
