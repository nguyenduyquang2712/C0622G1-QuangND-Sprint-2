package com.codegym.service.payment;

import com.codegym.model.payment.Payment;

import java.util.List;

public interface IPaymentService {
    Payment findPaymentByPaymentId(Integer paymentId);


    void updatePaymentStatus(Integer paymentId, Double total, String date);

    List<Payment> getCheckedPayment(Integer userId);
}
