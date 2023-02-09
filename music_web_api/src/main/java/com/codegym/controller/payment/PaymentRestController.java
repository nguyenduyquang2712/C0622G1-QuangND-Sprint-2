package com.codegym.controller.payment;

import com.codegym.model.payment.Payment;
import com.codegym.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/music/payment")
@CrossOrigin("*")
public class PaymentRestController {
    @Autowired
    IPaymentService paymentService;
    @GetMapping("paid/{id}")
    public ResponseEntity<List<Payment>> getCheckedPayment(@PathVariable Integer id){
        List<Payment> payments = paymentService.getCheckedPayment(id);
        return new ResponseEntity<>(payments,HttpStatus.OK);
    }
    @GetMapping("update")
    public ResponseEntity<?> updatePayment(@RequestParam("paymentId") Integer paymentId,
                                           @RequestParam("total") Double total,
                                           @RequestParam("date") String date){
        Payment payment = paymentService.findPaymentByPaymentId(paymentId);
        if(payment==null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        paymentService.updatePaymentStatus(paymentId,total, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
