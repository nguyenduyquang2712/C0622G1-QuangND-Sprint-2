package com.codegym.repository.payment;

import com.codegym.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {
    @Query(value="select * from payment where user_id =:userId Limit 0,1", nativeQuery = true)
    Payment findPaymentId(Integer userId);
}
