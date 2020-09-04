package com.dxb.payment.service.impl;


import com.dxb.payment.dao.PaymentDao;
import com.dxb.payment.entity.PaymentModel;
import com.dxb.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int createPayment(PaymentModel paymentModel) {
        return paymentDao.createPayment(paymentModel);
    }

    @Override
    public PaymentModel getPaymentModel(Long id) {
        return paymentDao.getPayment(id);
    }
}
