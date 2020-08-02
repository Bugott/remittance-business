package com.zh2.training.domain.message;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author Phoenix
 *
 */
@Data
public class Message {
    private String ourBankBiccode;
    private String sourceBankBiccode;
    private String payBank;
    private String middleBank;
    private String payMethod;
    private String aimBank;
    @Autowired
    Creditor creditor;
    @Autowired
    Debitor debitor;

    public static Message create(String messageStr){
        MessageHandleService messageHandleService = new MessageHandleService();
        String regex = "\\{1:\\w{3}[A-Z]{12}[0-9]{10}\\}" +
                "\\{2:\\w{47}\\}" +
                "\\{4:\\s" +
                ":20:\\w{16}\\s" +
                ":23B:[A-Z]{4}\\s" +
                ":50K:/[0-9]{1,34}+\\s" +
                "[a-zA-Z]+,[a-zA-Z]+\\s" +
                "(:52A:\\w{11}\\s)?" +
                "(:56A:\\w{11}\\s)?" +
                ":57A:\\w{11}\\s" +
                ":59:/[0-9]{1,34}+\\s" +
                "[a-zA-Z]+,[a-zA-Z]+\\s" +
                ":71A:\\w+\\s\\}";
        if(!messageStr.matches(regex)){
            return null;
        }
        String []messageArr = messageStr.split("\\}|\\n");
        int message_length = messageArr.length;

        if (message_length == 13){
            System.out.println("52项和56项均有，下一手银行为56项");
            Message messageResult = messageHandleService.bothMethod(messageArr);
            return messageResult;
        }else if (message_length == 11){
            System.out.println("52项和56项均没有，下一手银行为57项");
            Message messageResult = messageHandleService.neitherMethod(messageArr);
            return messageResult;
        }else{
            System.out.println("52项和56项只含有一个");
            String flag = messageArr[7].substring(1,3);
            if (flag.equals("52")){
                System.out.println("仅含有52项，下一手银行为57项");
                Message messageResult = messageHandleService.fiftyTwoMethod(messageArr);
                return messageResult;
            }else {
                System.out.println("仅含有56项，下一手银行为56项");
                Message messageResult = messageHandleService.fiftySixMethod(messageArr);
                return messageResult;
            }
        }

    }
}
