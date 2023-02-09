package com.codegym.repository.payment;

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
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {
    @Query(value="select * from payment where payment_status=0 " +
            "and user_id =:userId Limit 0,1", nativeQuery = true)
    Payment findPaymentId(@Param("userId") Integer userId);

    @Modifying
    @Query(value="insert into payment (payment_status, user_id) values (0,:userId)", nativeQuery = true)
    void addPayment( @Param("userId") Integer userId);

    @Query(value="select * from payment where id=:paymentId and payment_status=0 ", nativeQuery = true)
    Payment findPaymentIdByPaymentId(@Param("paymentId") Integer paymentId);

    @Modifying
    @Query(value=" update payment set payment_status=1, total_price=:total, order_date=:date where id=:paymentId ", nativeQuery = true)
    void updatePaymentStatus(Integer paymentId,
                             @Param("total") Double total,
                             @Param("date") String date);
    @Query(value="select * from payment where payment_status=1 and user_id=:userId", nativeQuery = true)
    List<Payment> getCheckedPayment(@Param("userId") Integer userId);
}
