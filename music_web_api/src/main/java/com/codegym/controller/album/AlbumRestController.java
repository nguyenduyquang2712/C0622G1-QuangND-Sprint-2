package com.codegym.controller.album;

import com.codegym.model.album.Album;
import com.codegym.model.payment.OrderAlbum;
import com.codegym.model.payment.Payment;
import com.codegym.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/music")
@CrossOrigin("*")
public class AlbumRestController {
    @Autowired
    private IAlbumService albumService;

    //    @GetMapping()
//    public ResponseEntity<List<Album>> getAlbums(){
//        List<Album> albums = albumService.getAllAlbums();
//        if(albums.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(albums, HttpStatus.OK);
//    }
    @GetMapping()
    public ResponseEntity<Page<Album>> getAlbums(@PageableDefault(value = 6)Pageable pageable, @RequestParam String name) {
        Page<Album> albums = albumService.getAllAlbums(pageable, name);
        if (albums.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable int id){
        return new ResponseEntity<>(albumService.getAlbumById(id), HttpStatus.OK);
    }
    @GetMapping("orderAlbum/{userId}")
    public ResponseEntity<List<OrderAlbum>> getOrderAlbum(@PathVariable int userId){
        return new ResponseEntity<>(albumService.getOrderAlbumById(userId), HttpStatus.OK);
    }
    @GetMapping("add")
    public ResponseEntity <?> addOrderAlbum(@RequestParam("id") Integer id, @RequestParam("userId") Integer userId) {
       Payment payment = albumService.findPaymentId(userId);
       if(payment!=null){
           albumService.addOrderAlbum(id, payment.getId());
       }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
