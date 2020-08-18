package com.zh2.training.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zh2.training.domain.agentbank.Bank;
import com.zh2.training.domain.agentbank.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Bugott
 */
@Repository
public class BankRepositoryImpl implements BankRepository {

    @Autowired
    BankMapper bankMapper;

    @Override
    public Bank getBankByBic(String bic) {
        QueryWrapper<Bank> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Bank::getBic,bic);
        Bank bank = bankMapper.selectOne(wrapper);
        return bank;
    }
}
