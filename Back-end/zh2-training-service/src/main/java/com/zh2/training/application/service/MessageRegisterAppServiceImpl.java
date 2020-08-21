package com.zh2.training.application.service;

import com.zh2.training.domain.message.Message;
import com.zh2.training.domain.message.MessageHandleService;
import com.zh2.training.domain.message.MessageRepository;
import com.zh2.training.infrastructure.repository.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 存储报文简电信息的Service
 * @author Phoenix
 *
 */

@Controller
public class MessageRegisterAppServiceImpl {

    @Autowired
    MessageMapper messageMapper;
    @Autowired
    MessageHandleService messageHandleService;
    @Autowired
    MessageRepository messageRepository;

    //将报文简电存储到数据库message
    @RequestMapping("/save")
    public void saveMessage(@RequestParam("message") String message){
        Message messageAfterSplit = messageHandleService.analyse(message);
        messageRepository.setOurbankbic(messageAfterSplit.getOurBankBic());
        messageRepository.setSourcebankbic(messageAfterSplit.getSourceBankBic());
        messageRepository.setPaybank(messageAfterSplit.getPayBank());
        messageRepository.setMiddlebank(messageAfterSplit.getMiddleBank());
        messageRepository.setPaymethod(messageAfterSplit.getPayMethod());
        messageRepository.setAimbank(messageAfterSplit.getAimBank());

        messageMapper.insert(messageRepository);
        System.out.println(messageRepository);
    }

}
