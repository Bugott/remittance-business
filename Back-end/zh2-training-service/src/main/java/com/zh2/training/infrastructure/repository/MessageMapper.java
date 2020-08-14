package com.zh2.training.infrastructure.repository;

import com.zh2.training.domain.message.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MessageMapper {

    public List<Message> getAll();

    public Message getMessageById(Integer id);

    public int deleteMessageById(Integer id);

    public int insertMessage(Message massage);

    public int updateMessage(Message massage);
}
