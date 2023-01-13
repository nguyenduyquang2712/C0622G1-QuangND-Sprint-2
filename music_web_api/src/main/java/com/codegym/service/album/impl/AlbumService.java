package com.codegym.service.album.impl;

import com.codegym.model.album.Album;
import com.codegym.repository.album.IAlbumReporitory;
import com.codegym.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService implements IAlbumService {
    @Autowired
    private IAlbumReporitory albumReporitory;
    @Override
    public List<Album> getAllAlbums() {
        return albumReporitory.findAll();
    }
}
