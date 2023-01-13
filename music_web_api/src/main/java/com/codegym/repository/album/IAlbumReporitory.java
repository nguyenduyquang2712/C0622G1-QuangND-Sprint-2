package com.codegym.repository.album;

import com.codegym.model.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface IAlbumReporitory extends JpaRepository<Album,Integer> {
}
