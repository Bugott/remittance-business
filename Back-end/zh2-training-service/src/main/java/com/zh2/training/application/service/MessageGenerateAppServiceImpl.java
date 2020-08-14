package com.zh2.training.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh2.training.domain.message.*;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
public class MessageGenerateAppServiceImpl {

    //拆解swift报文服务

    @RequestMapping("/")
    @ResponseBody
    public static void main(String[] args) {
        MessageHandleService messageHandleService = new MessageHandleService();
        NameAddressSplitClient nameAddressSplitClient = new NameAddressSplitClient();
        Message result = messageHandleService.analyse( "{1:F01ICBKCNBJAXXX0001161255}" +
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
        System.out.println(result);
        System.out.println(result.getDebitor().getDebitorInformation());
        System.out.println(result.getCreditor());
        Debitor debitor = (Debitor) nameAddressSplitClient.split(result.getDebitor().getDebitorInformation());//解析50项
        Creditor creditor = (Creditor) nameAddressSplitClient.split(result.getCreditor().getCreditorInformation());//解析59项
        /*
        //JSON映射器
        ObjectMapper mapper = new ObjectMapper();
        //将java对象转换成字符串
        String str = mapper.writeValueAsString(result);
        return str;
        */
    }
}
