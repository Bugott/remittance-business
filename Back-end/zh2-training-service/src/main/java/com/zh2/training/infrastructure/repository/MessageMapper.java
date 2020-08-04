package com.zh2.training.infrastructure.repository;

import com.zh2.training.domain.message.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {

    public Message getMessageById();
}
