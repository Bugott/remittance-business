package com.zh2.training.infrastructure.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh2.training.domain.message.MessageRepository;
import org.apache.ibatis.annotations.*;

/**
 * 用来将报文简电信息存入数据库
 */
@Mapper
public interface MessageMapper extends BaseMapper<MessageRepository> {

}
