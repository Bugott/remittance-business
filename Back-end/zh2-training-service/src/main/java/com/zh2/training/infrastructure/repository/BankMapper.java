package com.zh2.training.infrastructure.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh2.training.domain.agentbank.Bank;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Bugott
 */
@Mapper
public interface BankMapper extends BaseMapper<Bank> {

}
