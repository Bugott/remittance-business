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
        ArrayList<LinkedList<AgentBank>> candidatePath = new ArrayList<>();
        getPath(candidatePath, principalBank, agentBank, 1, limit);
        return candidatePath;
    }


    @Override
    public void getPath(ArrayList<LinkedList<AgentBank>> candidatePath, String principalBank, String agentBank, int depth, int limit) {
        if (depth > limit) {
            return;
        }
        Map<String, Object> columnMap = new HashMap<>(2);
        columnMap.put("principal_bank", principalBank);
        List<AgentBank> principalBanks = agentBankMapper.selectByMap(columnMap);
        for (AgentBank bank : principalBanks) {
            if (bank.getAgentBank().equals(agentBank)) {
                LinkedList<AgentBank> path = new LinkedList<>();
                path.add(bank);
                candidatePath.add(path);
            } else {
                getPath(candidatePath, bank.getAgentBank(), agentBank, ++depth, limit);
            }
        }
    }
}
