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

    @Autowired
    BankRepository bankRepository;

    public ArrayList<ArrayList<ArrayList<String>>> calculate(Message message) {
        ArrayList<LinkedList<AgentBank>> paths;
        if (message.getMiddleBank() == null || "".equals(message.getMiddleBank())) {
            //中间行为空时，查找我行与收款行(57项)之间可行的代理清算路径;
            paths = agentBankRepository.retrieve(message.getOurBankBiccode(), message.getAimBank(), 4);
        } else {
            //中间行不为空时，查找我行与中间行(56项)之间可行的代理清算路径;
            paths = agentBankRepository.retrieve(message.getOurBankBiccode(), message.getMiddleBank(), 3);
        }
        //使用Lambda表达式，根据权值排序
        paths.sort((path1, path2) -> {
            int path1Weight = 0, path2Weight = 0;
            for (AgentBank agentBank : path1) {
                path1Weight += agentBank.getCost() * 8 + agentBank.getRequiredTime() * 2;
            }
            for (AgentBank agentBank : path2) {
                path2Weight += agentBank.getCost() * 8 + agentBank.getRequiredTime() * 2;
            }
            return path1Weight - path2Weight;
        });
        System.out.println(paths);
        ArrayList<ArrayList<ArrayList<String>>> finalPaths = new ArrayList<>(4);
        for (int i = 0; i < 3; i++) {
            LinkedList<AgentBank> path = paths.get(i);
            ArrayList<ArrayList<String>> finalPath = new ArrayList<>(8);
            for (AgentBank agentBank : path) {
                Bank bank = bankRepository.getBankByBic(agentBank.getAgentBank());
                ArrayList<String> tempArray = new ArrayList<>(2);
                tempArray.add(bank.getCity());
                tempArray.add(bank.getBic());
                finalPath.add(tempArray);
            }
            finalPaths.add(finalPath);
        }
        return finalPaths;
    }

}
