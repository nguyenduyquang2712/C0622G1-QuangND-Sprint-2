package com.codegym.service.album;

import com.codegym.model.album.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAlbumService {
    List<Album> getAllAlbums();
    Page<Album> getAllAlbums(Pageable pageable);
}
