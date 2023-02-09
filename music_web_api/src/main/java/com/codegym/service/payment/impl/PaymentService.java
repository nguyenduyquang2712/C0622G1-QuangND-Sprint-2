package com.codegym.service.payment.impl;

import com.codegym.model.payment.Payment;
import com.codegym.repository.payment.IPaymentRepository;
import com.codegym.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    IPaymentRepository paymentRepository;
    @Override
    public Payment findPaymentByPaymentId(Integer paymentId) {
        return paymentRepository.findPaymentIdByPaymentId(paymentId);
    }

    @Override
    public void updatePaymentStatus(Integer paymentId, Double total, String date) {
        paymentRepository.updatePaymentStatus(paymentId, total, date);
    }

    @Override
    public List<Payment> getCheckedPayment(Integer userId) {
        return paymentRepository.getCheckedPayment(userId);
    }

}
