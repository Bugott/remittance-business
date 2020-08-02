package com.zh2.training.application.service;

import com.zh2.training.domain.message.Message;
import com.zh2.training.domain.message.MessageHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



public class MessageGenerateAppServiceImpl {



    //拆解swift报文服务
    public static void main(String[] args) {
        MessageHandleService messageHandleService = new MessageHandleService();
        Message result = messageHandleService.analyse("{1:F01ICBKCNBJAXXX0001161255}" +
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
    }
}
