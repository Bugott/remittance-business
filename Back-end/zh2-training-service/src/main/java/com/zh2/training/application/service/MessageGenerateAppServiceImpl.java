package com.zh2.training.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh2.training.domain.agentbank.AgentBank;
import com.zh2.training.domain.agentbank.MsgPathCalculateService;
import com.zh2.training.domain.message.*;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MessageGenerateAppServiceImpl {

    //拆解swift报文服务


    @ResponseBody
    @RequestMapping("/show")
    public static void main(String[] args) throws JsonProcessingException {
        MessageHandleService messageHandleService = new MessageHandleService();
        MsgPathCalculateService msgPathCalculateService = new MsgPathCalculateService();
        //三条最优的路径
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        //将简电拆分为Message对象
        Message message = messageHandleService.analyse( "{1:F01ICBKCNBJAXXX0001161255}{2:O1031924200721BOFAUS3NXXXX00012007212007211924N}{4:\n" +
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

        //调用路径计算功能，得到代理行信息
        ArrayList<LinkedList<AgentBank>> agentList = msgPathCalculateService.calculate(message);
        System.out.println(agentList);
        //将相应的信息写入三条路径





        //包含最终三条路径的结果
        List<Path> result = new ArrayList<>();

        result.add(path1);
        result.add(path2);
        result.add(path3);

        //model.addAttribute();

        //JSON映射器
        ObjectMapper mapper = new ObjectMapper();
        //将java对象转换成字符串
        String jsonStr = mapper.writeValueAsString(result);
        System.out.println(jsonStr);
    }
}
