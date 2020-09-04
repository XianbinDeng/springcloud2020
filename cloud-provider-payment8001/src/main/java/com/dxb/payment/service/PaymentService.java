package com.dxb.payment.service;

import com.dxb.payment.entity.PaymentModel;

public interface PaymentService {
    int createPayment(PaymentModel paymentModel);
    PaymentModel getPaymentModel(Long id);
}
