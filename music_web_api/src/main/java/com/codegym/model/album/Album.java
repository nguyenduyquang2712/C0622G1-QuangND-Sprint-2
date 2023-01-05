package com.codegym.model.album;

import com.codegym.model.payment.OrderAlbum;
import com.codegym.model.song.Song;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String genre;
    private String releaseDate;
    private Integer instock_status;
    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeAlbum typeAlbum;
    @OneToMany(mappedBy = "album")
    private Set<ImageAlbum> images;
    @OneToMany(mappedBy = "album")
    private Set<Song> songs;
    @OneToMany(mappedBy = "album")
    private Set<OrderAlbum>orderAlbums;

    public Album() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getInstock_status() {
        return instock_status;
    }

    public void setInstock_status(Integer instock_status) {
        this.instock_status = instock_status;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public TypeAlbum getTypeAlbum() {
        return typeAlbum;
    }

    public void setTypeAlbum(TypeAlbum typeAlbum) {
        this.typeAlbum = typeAlbum;
    }

    public Set<ImageAlbum> getImages() {
        return images;
    }

    public void setImages(Set<ImageAlbum> images) {
        this.images = images;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Set<OrderAlbum> getOrderAlbums() {
        return orderAlbums;
    }

    public void setOrderAlbums(Set<OrderAlbum> orderAlbums) {
        this.orderAlbums = orderAlbums;
    }
}
