package com.codegym.service.album.impl;

import com.codegym.model.album.Album;
import com.codegym.model.payment.OrderAlbum;
import com.codegym.model.payment.Payment;
import com.codegym.repository.album.IAlbumReporitory;
import com.codegym.repository.payment.IOrderAlbumRepository;
import com.codegym.repository.payment.IPaymentRepository;
import com.codegym.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService implements IAlbumService {
    @Autowired
    private IAlbumReporitory albumReporitory;
    @Autowired
    private IOrderAlbumRepository orderAlbumRepository;
    @Autowired
    private IPaymentRepository paymentRepository;
    @Override
    public List<Album> getAllAlbums() {
        return albumReporitory.findAll();
    }

    @Override
    public Page<Album> getAllAlbums(Pageable pageable, String nameAlbum) {
        return albumReporitory.findAll( nameAlbum, pageable);
    }

    @Override
    public Album getAlbumById(int id) {
        return albumReporitory.getAlBumById(id);
    }

    @Override
    public List<OrderAlbum> getOrderAlbumById(int userId) {
        return orderAlbumRepository.getOrderAlbumById(userId);
    }

    @Override
    public void addOrderAlbum(Integer id,Integer amount, Integer paymentId) {
        orderAlbumRepository.addOrderAlbum(id, amount,paymentId);
    }

    @Override
    public Payment findPaymentId(Integer userId) {
        return paymentRepository.findPaymentId(userId);
    }

    @Override
    public OrderAlbum findOrderAlbum(Integer id, Integer paymentId) {
        return orderAlbumRepository.findOrderAlbumById(id, paymentId);
    }

    @Override
    public void updateOrderAlbum(Integer id, Integer amount, Integer paymentId) {
       orderAlbumRepository.updateOrderAlbum(id, amount, paymentId);
    }

    @Override
    public void addPayment(Integer userId) {
        paymentRepository.addPayment(userId);
    }

    @Override
    public void deleteOrderAlbum(Integer id) {
        orderAlbumRepository.deleteOrderAlbum(id);
    }


}
