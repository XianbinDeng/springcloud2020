package com.dxb.payment.dao;

import com.dxb.payment.entity.PaymentModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
     int createPayment(PaymentModel paymentModel);
     PaymentModel getPayment(Long id);

}
