package com.jktb.jiaktb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jktb.jiaktb.mapper.DisRuleMapper;
import com.jktb.jiaktb.domain.DisRule;
import com.jktb.jiaktb.service.IDisRuleService;

/**
 * 优惠配置Service业务层处理
 * 
 * @author jktb
 * @date 2021-03-15
 */
@Service
public class DisRuleServiceImpl implements IDisRuleService 
{
    @Autowired
    private DisRuleMapper disRuleMapper;

    /**
     * 查询优惠配置
     * 
     * @param disRuleId 优惠配置ID
     * @return 优惠配置
     */
    @Override
    public DisRule selectDisRuleById(Long disRuleId)
    {
        return disRuleMapper.selectDisRuleById(disRuleId);
    }

    /**
     * 查询优惠配置列表
     * 
     * @param disRule 优惠配置
     * @return 优惠配置
     */
    @Override
    public List<DisRule> selectDisRuleList(DisRule disRule)
    {
        return disRuleMapper.selectDisRuleList(disRule);
    }

    /**
     * 新增优惠配置
     * 
     * @param disRule 优惠配置
     * @return 结果
     */
    @Override
    public int insertDisRule(DisRule disRule)
    {
        return disRuleMapper.insertDisRule(disRule);
    }

    /**
     * 修改优惠配置
     * 
     * @param disRule 优惠配置
     * @return 结果
     */
    @Override
    public int updateDisRule(DisRule disRule)
    {
        return disRuleMapper.updateDisRule(disRule);
    }

    /**
     * 批量删除优惠配置
     * 
     * @param disRuleIds 需要删除的优惠配置ID
     * @return 结果
     */
    @Override
    public int deleteDisRuleByIds(Long[] disRuleIds)
    {
        return disRuleMapper.deleteDisRuleByIds(disRuleIds);
    }

    /**
     * 删除优惠配置信息
     * 
     * @param disRuleId 优惠配置ID
     * @return 结果
     */
    @Override
    public int deleteDisRuleById(Long disRuleId)
    {
        return disRuleMapper.deleteDisRuleById(disRuleId);
    }
}
