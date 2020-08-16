package com.zh2.training.infrastructure.repository;

import com.zh2.training.domain.agentbank.AgentBank;
import com.zh2.training.domain.agentbank.AgentBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Bugott
 *
 */
@Repository
public class AgentBankRepositoryImpl implements AgentBankRepository {

    @Autowired
    AgentBankMapper agentBankMapper;

    @Override
    public ArrayList<LinkedList<AgentBank>> retrieve(String principalBank, String agentBank, int limit) {
        ArrayList<LinkedList<AgentBank>> candidatePaths = new ArrayList<>();
        //拿到下一手代理行列表
        List<AgentBank> agentBanks = getAgentBanksByPrincipalBank(principalBank);
        //若没有代理行，则返回空
        if (agentBanks == null || agentBanks.size() == 0) {
            return null;
        }
        //对代理行列表中的各个代理行搜索可能的后续路径
        for (AgentBank bank : agentBanks) {
            LinkedList<AgentBank> path = new LinkedList<>();
            path.addLast(bank);
            //调用getPath()方法，内部递归回溯
            getPath(candidatePaths, path, agentBank, 1, limit);
        }
        return candidatePaths;
    }


    @Override
    public void getPath(ArrayList<LinkedList<AgentBank>> candidatePaths, LinkedList<AgentBank> path, String agentBank, int depth, int limit) {
        //若递归深度参数depth超过limit，则不进行后续递归
        if (depth > limit) {
            return;
        }
        //判断下一手代理行是否是目标行(可能是中间行/中间行)
        if (path.getLast().getAgentBank().equals(agentBank)) {
            //如果是，则该路径为可行路径，加入到结果列表中(注意这里需要用到复制而不是引用)
            LinkedList<AgentBank> workablePath = new LinkedList<>();
            for (AgentBank bank : path) {
                workablePath.addLast(bank);
            }
            candidatePaths.add(workablePath);
            return;
        }
        //否则继续查询该代理行的下一手代理行，得出下一手代理行列表
        List<AgentBank> agentBanks = getAgentBanksByPrincipalBank(path.getLast().getAgentBank());
        //对下一手代理行列表中的各个代理行进行递归回溯
        for (AgentBank bank : agentBanks) {
            path.addLast(bank);
            getPath(candidatePaths, path, agentBank, ++depth, limit);
            depth--;
            path.remove(bank);
        }
    }

    @Override
    public List<AgentBank> getAgentBanksByPrincipalBank(String principalBank) {
        //使用HashMap放入查询条件对数据库表进行查询
        Map<String, Object> columnMap = new HashMap<>(2);
        columnMap.put("principal_bank", principalBank);
        return agentBankMapper.selectByMap(columnMap);
    }
}