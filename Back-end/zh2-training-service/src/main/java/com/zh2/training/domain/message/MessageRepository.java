package com.zh2.training.domain.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *将报文简电存储到数据库中的类，相比于Message去掉了Creditor和Debitor
 * @author Phoenix
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class MessageRepository {
    //我行BIC
    private String ourbankbic;
    //来源行BIC
    private String sourcebankbic;
    //付款行
    private String paybank;
    //中间行
    private String middlebank;
    //付款方式
    private String paymethod;
    //目标行
    private String aimbank;
}
