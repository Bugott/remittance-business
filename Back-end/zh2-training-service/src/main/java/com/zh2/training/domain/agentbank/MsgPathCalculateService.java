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

    public ArrayList<LinkedList<AgentBank>> calculate(Message message){

        ArrayList<LinkedList<AgentBank>> candidatePath = new ArrayList<>();


        return candidatePath;
    }
}
