package com.zh2.training.domain.message;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@Repository
public class Debitor implements Serializable {
    //收款人账户
    private String debitorAccountNumber;
    //收款人姓名和地址
    private String debitorInformation;
}
