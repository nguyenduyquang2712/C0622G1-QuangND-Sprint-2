package com.codegym.controller.album;

import com.codegym.model.album.Album;
import com.codegym.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/music")
@CrossOrigin("*")
public class AlbumRestController {
    @Autowired
    private IAlbumService albumService;
    @GetMapping()
    public ResponseEntity<List<Album>> getAlbums(){
        List<Album> albums = albumService.getAllAlbums();
        if(albums.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }
}
