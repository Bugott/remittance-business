package com.zh2.training.controller;

import com.zh2.training.domain.agentbank.BankRepository;
import com.zh2.training.domain.agentbank.MsgPathCalculateService;
import com.zh2.training.domain.message.Message;
import com.zh2.training.domain.message.MessageHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CalculateController {

    @Autowired
    MsgPathCalculateService msgPathCalculateService;

    @Autowired
    MessageHandleService messageHandleService;

    @Autowired
    BankRepository bankRepository;

    @RequestMapping(path = "/calculate")
    public ModelMap test(@RequestParam("message") String messageStr) {
        ModelMap modelMap = new ModelMap();
        Message message = messageHandleService.analyse(messageStr);
        ArrayList<ArrayList<ArrayList<String>>> paths = msgPathCalculateService.calculate(message);

        return modelMap;
    }
}
