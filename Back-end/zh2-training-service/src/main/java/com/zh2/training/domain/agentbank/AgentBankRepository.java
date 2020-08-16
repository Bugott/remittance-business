package com.zh2.training.domain.agentbank;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Bugott
 */
@Repository
public interface AgentBankRepository {
    /**
     * 获取代理行
     *
     * @return AgentBank
     */
    ArrayList<LinkedList<AgentBank>> retrieve(String principalBank, String agentBank, int limit);

    void getPath(ArrayList<LinkedList<AgentBank>> candidatePath, LinkedList<AgentBank> path, String agentBank, int depth, int limit);

    List<AgentBank> getAgentBanksByPrincipalBank(String principalBank);
}
