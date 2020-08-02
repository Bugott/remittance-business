package com.zh2.training.domain.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class Debitor implements Serializable {
    private String debitorAccountNumber;
    private String debitorInformation;


}

