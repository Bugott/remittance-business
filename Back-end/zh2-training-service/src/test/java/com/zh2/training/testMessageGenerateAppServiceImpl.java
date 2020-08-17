package com.zh2.training;

import com.zh2.training.domain.message.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class testMessageGenerateAppServiceImpl {
    public static void main(String[] args) {
        Message message = new Message();
        message.create("{1:F01ICBKCNBJAXXX0001161255}" +
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
        
        /*String regex = "\\{1:\\w{3}[A-Z]{12}[0-9]{10}\\}" +
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

        String messageStr = "{1:F01ICBKCNBJAXXX0001161255}" +
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
                "}";


        System.out.println(messageStr.matches(regex));
        String []arr = messageStr.split("\\}|\\n");
        int message_length = arr.length;
        if (message_length == 13){
            System.out.println("52项和56项均有");
        }else if (message_length == 11){
            System.out.println("52项和56项均没有");
        }else{
            System.out.println("52项和56项只含有一个");
            String flag = arr[7].substring(1,3);
            if (flag.equals("52")){
                System.out.println("仅含有52项");
            }else {
                System.out.println("仅含有56项");

            }
        }

        System.out.println(Arrays.toString(arr));
        HashMap<String, String> informationMap = new HashMap<String, String>();
        for (String s : arr) {
            System.out.println(s);
        }
        //1开头部分
        String partOne = arr[0];
        String ourBankBiccode = partOne.substring(6,14)+partOne.substring(15,18);
        //2开头部分
        String partTwo = arr[1];
        String sourceBankBiccode = partTwo.substring(17,25)+partTwo.substring(26,29);
        //付款人信息
        String creditorAccountNumber = arr[5];
        String creditorInformation = arr[6];
        //52项付款行(可能为空)
        String payBank = arr[7].substring(5);
        //56项中间行(可能为空)
        String middleBank = arr[8].substring(5);
        //57项收款行
        String aimBank = arr[message_length-4].substring(5);
        //收款人信息
        String debitorAccountNumber = arr[message_length-3].substring(5);
        String debitorInformation = arr[message_length-2];
        //付款方式
        String payMethod = arr[message_length-1].substring(5);
        System.out.println(aimBank);*/



    }
}
