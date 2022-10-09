package com.example.informationSystem.service;

import com.example.informationSystem.entity.FinancialProgress;

/**
 * @author pcdn
 */
public interface FinancialProgressService {

    /**
     * 添加项目财务进度数据
     * @param financialProgress 项目财务进度对象
     * @return 是否成功
     */
    boolean addFinancialProgressService(FinancialProgress financialProgress);

}
