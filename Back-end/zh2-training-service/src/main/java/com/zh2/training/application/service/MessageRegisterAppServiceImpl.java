package com.zh2.training.application.service;

import com.zh2.training.domain.message.Message;
import com.zh2.training.domain.message.MessageHandleService;
import com.zh2.training.domain.message.MessageRepository;
import com.zh2.training.infrastructure.repository.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



/**
 * 存储报文简电信息的Service
 * @author Phoenix
 *
 */

@RestController
public class MessageRegisterAppServiceImpl {

    @Autowired
    MessageMapper messageMapper;
    @Autowired
    MessageHandleService messageHandleService;
    @Autowired
    MessageRepository messageRepository;

    //将报文简电注册到数据库message
    @RequestMapping(path = "/save",consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public void saveMessage(@RequestParam(value="message") String message){
        Message messageAfterSplit = messageHandleService.analyse(message);
        if(null!=messageAfterSplit){
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
    //指定id查询注册的报文
    @RequestMapping("/find/{id}")
    public MessageRepository selectMessageById(@PathVariable("id") int id){
        MessageRepository result = messageMapper.selectById(id);
        return result;
    }
    //查询所有注册的报文
    /*@RequestMapping("/findAll")
    public List<MessageRepository> selectAllMessage(){
        messageMapper.selectList();
    }*/

}
