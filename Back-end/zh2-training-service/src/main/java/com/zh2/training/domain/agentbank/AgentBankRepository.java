package com.zh2.training.domain.agentbank;

import org.springframework.stereotype.Repository;

/**
 * @author Bugott
 */
@Repository
public interface AgentBankRepository {
    /**
     * 获取代理行
     * @return AgentBank
     */
    AgentBank retrieve();
}
