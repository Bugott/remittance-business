package com.zh2.training.domain.agentbank;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Bugott
 *
 */
@Repository
public interface AgentBankRepository {
    /**
     * 计算获取最优汇款路径列表主方法
     * @return ArrayList<LinkedList<AgentBank>>
     */
    ArrayList<LinkedList<AgentBank>> retrieve(String principalBank, String agentBank, int limit);
    /**
     * 获取所有可行的汇款路径，其中有进行递归以及用到了回溯算法
     * @return void
     */
    void getPath(ArrayList<LinkedList<AgentBank>> candidatePath, LinkedList<AgentBank> path, String agentBank, int depth, int limit);
    /**
     * 已被代理行作为查询条件从数据库表中得到所有能代理其的代理行的相关记录数据
     * @return List<AgentBank>
     */
    List<AgentBank> getAgentBanksByPrincipalBank(String principalBank);
}
