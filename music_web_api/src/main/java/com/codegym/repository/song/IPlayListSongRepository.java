package com.codegym.repository.song;

import com.codegym.model.song.PlayListSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IPlayListSongRepository extends JpaRepository<PlayListSong,Integer> {
}
