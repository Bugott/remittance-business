package com.zh2.training.domain.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class Creditor implements Serializable {
    private String creditorAccountNumber;
    private String creditorInformation;
}
