package com.codegym.repository.song;

import com.codegym.model.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ISongRepository extends JpaRepository<Song,Integer> {
}
