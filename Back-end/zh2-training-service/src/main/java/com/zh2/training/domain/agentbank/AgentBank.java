package com.zh2.training.domain.agentbank;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Bugott
 */
@Data
public class AgentBank implements Serializable {

    private int id;
    //被代理行BIC
    private String principalBank;
    //代理行BIC
    private String agentBank;
    //币种
    private String currency;
    //所需费用
    private double cost;
    //所需时间
    private int requiredTime;

    public AgentBank() {
    }
    public AgentBank(String agentBank) {
        this.agentBank = agentBank;
    }
}
