package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.FinancialProgress;
import com.example.informationSystem.mapper.FinancialProgressMapper;
import com.example.informationSystem.service.FinancialProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 10:05
 */
@Service
public class FinancialProgressServiceImpl implements FinancialProgressService {

    @Autowired
    private FinancialProgressMapper financialProgressMapper;

    @Override
    public boolean addFinancialProgressService(FinancialProgress financialProgress) {

        financialProgressMapper.insert(financialProgress);

        return true;

    }

}
