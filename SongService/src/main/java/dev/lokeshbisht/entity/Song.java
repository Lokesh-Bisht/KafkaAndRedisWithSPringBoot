package dev.lokeshbisht.entity;

import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_id", nullable = false)
    private Long artistId;

    @Column(name = "album_id")
    private Long albumId;

    @Column(nullable = false)
    private String href;

    private String type;

    private String format;

    private Integer duration;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;
}
