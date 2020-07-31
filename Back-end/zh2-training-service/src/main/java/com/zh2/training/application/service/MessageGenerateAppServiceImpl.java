package com.zh2.training.application.service;


import com.zh2.training.domain.message.MessageHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


public class MessageGenerateAppServiceImpl {
        
        @Autowired
        MessageHandleService messageHandleService;

        //拆解swift报文服务

        messageHandleService.analyse(String messageStr);




}
