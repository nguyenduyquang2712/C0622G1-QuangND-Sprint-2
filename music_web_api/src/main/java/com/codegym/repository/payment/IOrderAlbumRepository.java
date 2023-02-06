package com.codegym.repository.payment;

import com.codegym.model.payment.OrderAlbum;
import com.codegym.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IOrderAlbumRepository extends JpaRepository<OrderAlbum, Integer> {
    @Query(value = "SELECT  order_album.* FROM order_album join payment on order_album.payment_id= payment.id \n" +
            "join `user` on `user`.id=payment.user_id where `user`.id =:userId and order_album.delete_status=0", nativeQuery = true)
    List<OrderAlbum> getOrderAlbumById(@Param("userId") int userId);

    @Modifying
    @Query(value = "Insert into order_album(quantity,album_id,payment_id) values (1,:id,:paymentId)", nativeQuery = true)
    void addOrderAlbum(@Param("id") Integer id,
                       @Param("paymentId") Integer paymentId);

}
