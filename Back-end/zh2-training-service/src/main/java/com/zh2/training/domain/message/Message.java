package com.zh2.training.domain.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Arrays;


/**
 *报文简电对象
 * @author Phoenix
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Message implements Serializable {
    //我行BIC
    private String ourBankBic;
    //来报行BIC
    private String sourceBankBic;
    //付款行
    private String payBank;
    //中间行
    private String middleBank;
    //付款方式
    private String payMethod;
    //收款行
    private String aimBank;
    //债权人（付款人）
    Creditor creditor;
    //债务人（收款人）
    Debitor debitor;

    /**
     * 拆分报文方法
     * @param messageStr
     * @return
     */
    public static Message create(String messageStr){
        MessageHandleService messageHandleService = new MessageHandleService();
        String regex = "\\{1:\\w{25}\\}" +
                "\\{2:\\w{47}\\}" +
                "\\{4:\\s" +
                ":20:\\w{16}\\s" +
                "(:23B:[A-Z]{4}\\s)?" +
                ":50K:/\\w+\\s" +
                "[a-zA-Z]+,[a-zA-Z]+\\s" +
                "(:52A:\\w{11}\\s)?" +
                "(:56A:\\w{11}\\s)?" +
                ":57A:\\w{11}\\s" +
                ":59:/\\w+\\s" +
                "[a-zA-Z]+,[a-zA-Z]+\\s" +
                ":71A:\\w+\\s\\}";
        if(!messageStr.matches(regex)){
            System.out.println("简电格式错误，请检查！");
            return null;
        }
        String []messageArr = messageStr.split("\\}|\\n");
        System.out.println(Arrays.toString(messageArr));
        int message_length = messageArr.length;
        System.out.println(message_length);
        if (message_length == 13){
            System.out.println("52项付款行和56项中间行均有");
            Message messageResult = messageHandleService.bothMethod(messageArr);
            return messageResult;
        }else if (message_length == 11){
            System.out.println("52项付款行和56项中间行均没有");
            Message messageResult = messageHandleService.neitherMethod(messageArr);
            return messageResult;
        }else{
            String flag = messageArr[7].substring(1,3);
            if (flag.equals("52")){
                System.out.println("含有52项付款行，不含有56项中间行");
                Message messageResult = messageHandleService.fiftyTwoMethod(messageArr);
                return messageResult;
            }else {
                System.out.println("含有56项中间行，不含有52项付款行");
                Message messageResult = messageHandleService.fiftySixMethod(messageArr);
                return messageResult;
            }
        }

    }
}