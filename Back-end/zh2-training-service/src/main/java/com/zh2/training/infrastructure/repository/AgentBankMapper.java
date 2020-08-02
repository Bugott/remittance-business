package com.zh2.training.infrastructure.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh2.training.domain.agentbank.AgentBank;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgentBankMapper extends BaseMapper<AgentBank> {

}
