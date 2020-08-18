package com.zh2.training.domain.message;

import lombok.Data;

import java.util.List;

@Data
public class Path {
    //费用
    private int cost;
    //付款人城市、姓名、地址、账户
    private List<Object> Debitor;
    //付款行城市及BIC
    private List<String> sourceBankCity;
    //我行城市及BIC
    private List<String> ourBankCity;
    //代理行1的城市及BIC
    private List<String> agentBankCity_1;
    //代理行2的城市及BIC
    private List<String> agentBankCity_2;
    //代理行3的城市及BIC
    private List<String> agentBankCity_3;
    //收款行的城市及BIC
    private List<String> aimBankCity;
    //收款人城市、姓名、地址、账户
    private List<Object> Creditor;
}
