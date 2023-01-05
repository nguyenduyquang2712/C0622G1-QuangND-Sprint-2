package com.codegym.model.song;

import com.codegym.model.album.Album;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String genre;
    private String image;
    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;
    @ManyToOne
    @JoinColumn(name = "album_id",referencedColumnName = "id")
    private Album album;
    @OneToMany(mappedBy = "song")
    private Set<PlayListSong> playListSongs;

    public Song() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<PlayListSong> getPlayListSongs() {
        return playListSongs;
    }

    public void setPlayListSongs(Set<PlayListSong> playListSongs) {
        this.playListSongs = playListSongs;
    }
}
