package com.zh2.training.infrastructure.repository;

import com.zh2.training.domain.agentbank.AgentBank;
import com.zh2.training.domain.agentbank.AgentBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Bugott
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
        //对代理行列表中的各个代理行搜索可能路径
        for (AgentBank bank : agentBanks) {
            LinkedList<AgentBank> path = new LinkedList<>();
            path.addLast(bank);
            getPath(candidatePaths, path, agentBank, 1, limit);
        }
        return candidatePaths;
    }


    @Override
    public void getPath(ArrayList<LinkedList<AgentBank>> candidatePaths, LinkedList<AgentBank> path, String agentBank, int depth, int limit) {
        if (depth > limit) {
            return;
        }
        if (path.getLast().getAgentBank().equals(agentBank)) {
            LinkedList<AgentBank> workablePath = new LinkedList<>();
            for (AgentBank bank : path) {
                workablePath.addLast(bank);
            }
            candidatePaths.add(workablePath);
            return;
        }
        List<AgentBank> agentBanks = getAgentBanksByPrincipalBank(path.getLast().getAgentBank());
        for (AgentBank bank : agentBanks) {
            path.addLast(bank);
            getPath(candidatePaths, path, agentBank, ++depth, limit);
            depth--;
            path.remove(bank);
        }
    }

    @Override
    public List<AgentBank> getAgentBanksByPrincipalBank(String principalBank) {
        Map<String, Object> columnMap = new HashMap<>(2);
        columnMap.put("principal_bank", principalBank);
        return agentBankMapper.selectByMap(columnMap);
    }
}