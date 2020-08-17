package com.zh2.training.domain.agentbank;

import lombok.Data;


@Data
public class Bank {
    /**
     * 自增主键id
     */
    private int id;
    /**
     *  Bank Identifier code
     */
    private String bic;
    /**
     * 银行名
     */
    private String name;
    /**
     * 银行所属国家
     */
    private String country;
    /**
     * 银行所属城市
     */
    private String city;
}
