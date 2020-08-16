package com.zh2.training.domain.agentbank;

import com.zh2.training.domain.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Bugott
 */
@Service
public class MsgPathCalculateService {

    @Autowired
    AgentBankRepository agentBankRepository;

    public ArrayList<LinkedList<AgentBank>> calculate(Message message) {
        ArrayList<LinkedList<AgentBank>> paths;
        if (message.getMiddleBank() == null || "".equals(message.getMiddleBank())) {
            //中间行为空时，查找我行与收款行(57项)之间可行的代理清算路径;
            paths = agentBankRepository.retrieve(message.getOurBankBiccode(), message.getAimBank(), 4);
        } else {
            //中间行不为空时，查找我行与中间行(56项)之间可行的代理清算路径;
            paths = agentBankRepository.retrieve(message.getOurBankBiccode(), message.getMiddleBank(), 3);
        }
        ArrayList<LinkedList<AgentBank>> candidatePaths = new ArrayList<>();
        //根据权值排序
        paths.sort((path1, path2) -> {
            int path1Weight = 0, path2Weight = 0;
            for (AgentBank agentBank : path1) {
                path1Weight += agentBank.getCost() * 8 + agentBank.getRequiredTime() * 2;
            }
            for (AgentBank agentBank : path2) {
                path2Weight += agentBank.getCost() * 8 + agentBank.getRequiredTime() * 2;
            }
            return path1Weight-path2Weight;
        });
        return candidatePaths;
    }
}
