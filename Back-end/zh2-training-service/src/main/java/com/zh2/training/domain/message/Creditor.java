package com.zh2.training.domain.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class Creditor implements Serializable {
    //付款人账户
    private String creditorAccountNumber;
    //付款人名称和地址
    private String creditorInformation;
}