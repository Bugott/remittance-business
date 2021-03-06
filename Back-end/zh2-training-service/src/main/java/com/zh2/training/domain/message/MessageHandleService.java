package com.zh2.training.domain.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Phoenix
 *
 */

@Service
public class MessageHandleService {

    Message message = new Message();
    Creditor creditor = new Creditor();
    Debitor debitor = new Debitor();

    public Message analyse(String messageStr){
        Message message = Message.create(messageStr);//解析swift简电
        return message;

    }

    /**
     * 不同情况的处理方法
     * @param messageArr
     * @return
     */
    //52项，56项均存在的处理方法
    public  Message bothMethod(String []messageArr){
        int message_length = messageArr.length;
        //1开头部分
        String partOne = messageArr[0];
        String ourBankBic = partOne.substring(6,14)+partOne.substring(15,18);
        //2开头部分
        String partTwo = messageArr[1];
        String sourceBankBic = partTwo.substring(17,25)+partTwo.substring(26,29);
        //付款人信息
        String creditorAccountNumber = messageArr[5].substring(6);
        String creditorInformation = messageArr[6];
        //52项付款行(可能为空)
        String payBank = messageArr[7].substring(5);
        //56项中间行(可能为空)
        String middleBank = messageArr[8].substring(5);
        //57项收款行
        String aimBank = messageArr[message_length-4].substring(5);
        //收款人信息
        String debitorAccountNumber = messageArr[message_length-3].substring(5);
        String debitorInformation = messageArr[message_length-2];
        //付款方式
        String payMethod = messageArr[message_length-1].substring(5);

        debitor.setDebitorAccountNumber(debitorAccountNumber);
        debitor.setDebitorInformation(debitorInformation);
        creditor.setCreditorAccountNumber(creditorAccountNumber);
        creditor.setCreditorInformation(creditorInformation);

        message.setOurBankBic(ourBankBic);
        message.setSourceBankBic(sourceBankBic);
        message.setCreditor(creditor);
        message.setDebitor(debitor);
        message.setMiddleBank(middleBank);
        message.setPayBank(payBank);
        message.setPayMethod(payMethod);
        message.setAimBank(aimBank);

        return message;

    }

    //52项，56项均不存在的处理方法
    public  Message neitherMethod(String []messageArr){
        int message_length = messageArr.length;
        //1开头部分
        String partOne = messageArr[0];
        String ourBankBic = partOne.substring(6,14)+partOne.substring(15,18);
        //2开头部分
        String partTwo = messageArr[1];
        String sourceBankBic = partTwo.substring(17,25)+partTwo.substring(26,29);
        //付款人信息
        String creditorAccountNumber = messageArr[5].substring(6);
        String creditorInformation = messageArr[6];
        //57项收款行
        String aimBank = messageArr[message_length-4].substring(5);
        //收款人信息
        String debitorAccountNumber = messageArr[message_length-3].substring(5);
        String debitorInformation = messageArr[message_length-2];
        //付款方式
        String payMethod = messageArr[message_length-1].substring(5);

        debitor.setDebitorAccountNumber(debitorAccountNumber);
        debitor.setDebitorInformation(debitorInformation);
        creditor.setCreditorAccountNumber(creditorAccountNumber);
        creditor.setCreditorInformation(creditorInformation);

        message.setOurBankBic(ourBankBic);
        message.setSourceBankBic(sourceBankBic);
        message.setCreditor(creditor);
        message.setDebitor(debitor);
        message.setMiddleBank("");
        message.setPayBank("");
        message.setPayMethod(payMethod);
        message.setAimBank(aimBank);

        return message;

    }

    //52项存在，56项不存在的处理方法
    public  Message fiftyTwoMethod(String []messageArr){
        int message_length = messageArr.length;
        //1开头部分
        String partOne = messageArr[0];
        String ourBankBic = partOne.substring(6,14)+partOne.substring(15,18);
        //2开头部分
        String partTwo = messageArr[1];
        String sourceBankBic = partTwo.substring(17,25)+partTwo.substring(26,29);
        //付款人信息
        String creditorAccountNumber = messageArr[5].substring(6);
        String creditorInformation = messageArr[6];
        //52项付款行(可能为空)
        String payBank = messageArr[7].substring(5);
        //57项收款行
        String aimBank = messageArr[message_length-4].substring(5);
        //收款人信息
        String debitorAccountNumber = messageArr[message_length-3].substring(5);
        String debitorInformation = messageArr[message_length-2];
        //付款方式
        String payMethod = messageArr[message_length-1].substring(5);

        debitor.setDebitorAccountNumber(debitorAccountNumber);
        debitor.setDebitorInformation(debitorInformation);
        creditor.setCreditorAccountNumber(creditorAccountNumber);
        creditor.setCreditorInformation(creditorInformation);

        message.setOurBankBic(ourBankBic);
        message.setSourceBankBic(sourceBankBic);
        message.setCreditor(creditor);
        message.setDebitor(debitor);
        message.setMiddleBank("");
        message.setPayBank(payBank);
        message.setPayMethod(payMethod);
        message.setAimBank(aimBank);

        return message;

    }

    //56项存在,52项不存在的处理方法
    public  Message fiftySixMethod(String []messageArr){
        int message_length = messageArr.length;
        //1开头部分
        String partOne = messageArr[0];
        String ourBankBic = partOne.substring(6,14)+partOne.substring(15,18);
        //2开头部分
        String partTwo = messageArr[1];
        String sourceBankBic = partTwo.substring(17,25)+partTwo.substring(26,29);
        //付款人信息
        String creditorAccountNumber = messageArr[5].substring(6);
        String creditorInformation = messageArr[6];
        //56项中间行(可能为空)
        String middleBank = messageArr[message_length-5].substring(5);
        //57项收款行
        String aimBank = messageArr[message_length-4].substring(5);
        //收款人信息
        String debitorAccountNumber = messageArr[message_length-3].substring(5);
        String debitorInformation = messageArr[message_length-2];
        //付款方式
        String payMethod = messageArr[message_length-1].substring(5);

        debitor.setDebitorAccountNumber(debitorAccountNumber);
        debitor.setDebitorInformation(debitorInformation);
        creditor.setCreditorAccountNumber(creditorAccountNumber);
        creditor.setCreditorInformation(creditorInformation);

        message.setOurBankBic(ourBankBic);
        message.setSourceBankBic(sourceBankBic);
        message.setCreditor(creditor);
        message.setDebitor(debitor);
        message.setMiddleBank(middleBank);
        message.setPayBank("");
        message.setPayMethod(payMethod);
        message.setAimBank(aimBank);

        return message;

    }

}