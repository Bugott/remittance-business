package com.zh2.training.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh2.training.domain.agentbank.AgentBank;
import com.zh2.training.domain.agentbank.MsgPathCalculateService;
import com.zh2.training.domain.message.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;

@Controller
public class MessageGenerateAppServiceImpl {

    //拆解swift报文服务

    @RequestMapping("/show")
    @ResponseBody
    public static void main(String[] args) {
        MessageHandleService messageHandleService = new MessageHandleService();
        MsgPathCalculateService msgPathCalculateService = new MsgPathCalculateService();

        Message message = messageHandleService.analyse( "{1:F01ICBKCNBJAXXX0001161255}" +
                "{2:O1031924200721BOFAUS3NXXXX00012007212007211924N}" +
                "{4:\n" +
                ":20:CWHZ202007211924\n" +
                ":23B:CRED\n" +
                ":50K:/1234\n" +
                "SMITH,BEIJING\n" +
                ":52A:BOFAUS2R888\n" +
                ":56A:BKCHCNSZSZN\n" +
                ":57A:BKCHHKHKXXX\n" +
                ":59:/2224\n" +
                "POLLY,HONGKONG\n" +
                ":71A:OUR\n" +
                "}");
        System.out.println(message);
        System.out.println(message.getDebitor().getDebitorInformation());
        System.out.println(message.getCreditor());

        //ArrayList<LinkedList<AgentBank>> path = msgPathCalculateService.calculate(message);

        //System.out.println(path);


        /*
        //JSON映射器
        ObjectMapper mapper = new ObjectMapper();
        //将java对象转换成字符串
        String str = mapper.writeValueAsString(result);
        return str;
        */
    }
}
