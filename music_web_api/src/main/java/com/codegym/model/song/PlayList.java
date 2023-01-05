package com.codegym.model.song;

import com.codegym.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PlayList {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;
    @OneToMany(mappedBy="playList")
    private Set<PlayListSong> playListSongs;
    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    public PlayList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<PlayListSong> getPlayListSongs() {
        return playListSongs;
    }

    public void setPlayListSongs(Set<PlayListSong> playListSongs) {
        this.playListSongs = playListSongs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
