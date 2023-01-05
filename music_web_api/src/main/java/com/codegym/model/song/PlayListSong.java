package com.codegym.model.song;

import javax.persistence.*;

@Entity
public class PlayListSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Song song;
    @ManyToOne
    @JoinColumn(name = "play_list_id",referencedColumnName = "id")
    private PlayList playList;

    public PlayListSong() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }
}
