package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.CostMapper;
import com.jktb.jiaktb.domain.Cost;
import com.jktb.jiaktb.service.ICostService;

/**
 * 学费明细Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-15
 */
@Service
public class CostServiceImpl implements ICostService 
{
    @Autowired
    private CostMapper costMapper;

    /**
     * 查询学费明细
     * 
     * @param costId 学费明细ID
     * @return 学费明细
     */
    @Override
    public Cost selectCostById(Long costId)
    {
        return costMapper.selectCostById(costId);
    }

    /**
     * 查询学费明细列表
     * 
     * @param cost 学费明细
     * @return 学费明细
     */
    @Override
    public List<Cost> selectCostList(Cost cost)
    {
        return costMapper.selectCostList(cost);
    }

    /**
     * 新增学费明细
     * 
     * @param cost 学费明细
     * @return 结果
     */
    @Override
    public int insertCost(Cost cost)
    {
        return costMapper.insertCost(cost);
    }

    /**
     * 修改学费明细
     * 
     * @param cost 学费明细
     * @return 结果
     */
    @Override
    public int updateCost(Cost cost)
    {
        return costMapper.updateCost(cost);
    }

    /**
     * 批量删除学费明细
     * 
     * @param costIds 需要删除的学费明细ID
     * @return 结果
     */
    @Override
    public int deleteCostByIds(Long[] costIds)
    {
        return costMapper.deleteCostByIds(costIds);
    }

    /**
     * 删除学费明细信息
     * 
     * @param costId 学费明细ID
     * @return 结果
     */
    @Override
    public int deleteCostById(Long costId)
    {
        return costMapper.deleteCostById(costId);
    }
}
