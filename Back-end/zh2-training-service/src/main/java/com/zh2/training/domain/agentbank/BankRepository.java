package com.zh2.training.domain.agentbank;


import org.springframework.stereotype.Repository;

/**
 * @author Bugott
 */
@Repository
public interface BankRepository {
    /**
     * 已BIC作为查询条件从数据库表中得到该BIC对应的银行条目信息
     * @param bic bic码
     * @return List<AgentBank>
     */
    Bank getBanksByBic(String bic);
}
