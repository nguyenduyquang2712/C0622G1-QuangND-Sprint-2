package com.codegym.repository.album;

import com.codegym.model.album.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface IAlbumReporitory extends JpaRepository<Album,Integer> {
    @Query(value = "select * from album order by release_date desc", nativeQuery =true)
    List<Album> findAll();
    @Query(value = "select * from album where title like %:nameAlbum% and delete_status=0 order by release_date desc ", nativeQuery =true)
    Page<Album> findAll(@Param("nameAlbum") String nameAlbum, Pageable pageable);
}
