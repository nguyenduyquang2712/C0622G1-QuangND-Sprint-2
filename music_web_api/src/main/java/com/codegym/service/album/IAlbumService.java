package com.codegym.service.album;

import com.codegym.model.album.Album;
import com.codegym.model.payment.OrderAlbum;
import com.codegym.model.payment.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAlbumService {
    List<Album> getAllAlbums();
    Page<Album> getAllAlbums(Pageable pageable, String nameAlbum);

    Album getAlbumById(int id);

    List<OrderAlbum> getOrderAlbumById(int userId);

    void addOrderAlbum(Integer id,Integer amount, Integer paymentId);

    Payment findPaymentId(Integer userId);


    OrderAlbum findOrderAlbum(Integer id, Integer paymentId);

    void updateOrderAlbum(Integer id, Integer amount, Integer paymentId);

    void addPayment(Integer userId);

    void deleteOrderAlbum(Integer id);
}
