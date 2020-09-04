package com.dxb.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommResult<T> implements Serializable {
    private int code;
    private String message;
    private T         data;

    public CommResult(int code, String message){
        this(code,message,null);
    }
}
