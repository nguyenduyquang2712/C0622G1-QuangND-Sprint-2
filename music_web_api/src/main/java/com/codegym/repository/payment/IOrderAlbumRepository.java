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
    @Query(value = "SELECT  order_album.* FROM order_album " +
            "join payment on order_album.payment_id= payment.id \n" +
            "join `user` on `user`.id=payment.user_id" +
            " where `user`.id =:userId and order_album.delete_status=0", nativeQuery = true)
    List<OrderAlbum> getOrderAlbumById(@Param("userId") int userId);

    @Modifying
    @Query(value = "Insert into order_album(album_id,quantity,payment_id) " +
            "values (:id,:amount,:paymentId)", nativeQuery = true)
    void addOrderAlbum(@Param("id") Integer id,
                       @Param("amount") Integer amount,
                       @Param("paymentId") Integer paymentId);

    @Query(value = "select * from order_album " +
            "where delete_status = 0 " +
            "and album_id=:id " +
            "and payment_id=:paymentId ", nativeQuery = true)
    OrderAlbum findOrderAlbumById(@Param("id") Integer id,
                                  @Param("paymentId") Integer paymentId);

    @Modifying
    @Query(value = "update order_album " +
            "set order_album.quantity=:amount " +
            "where order_album.album_id=:id and order_album.payment_id=:paymentId ", nativeQuery = true)
    void updateOrderAlbum(@Param("id") Integer id,
                          @Param("amount") Integer amount,
                          @Param("paymentId") Integer paymentId);

    @Modifying
    @Query(value="update order_album" +
            " set order_album.delete_status=1 where order_album.id=:id", nativeQuery = true)
    void deleteOrderAlbum(@Param("id") Integer id);
}
