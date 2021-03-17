package com.jktb.jiaktb.service;

import java.util.List;
import com.jktb.jiaktb.domain.DisRule;

/**
 * 优惠配置Service接口
 * 
 * @author jktb
 * @date 2021-03-15
 */
public interface IDisRuleService 
{
    /**
     * 查询优惠配置
     * 
     * @param disRuleId 优惠配置ID
     * @return 优惠配置
     */
    public DisRule selectDisRuleById(Long disRuleId);

    /**
     * 查询优惠配置列表
     * 
     * @param disRule 优惠配置
     * @return 优惠配置集合
     */
    public List<DisRule> selectDisRuleList(DisRule disRule);

    /**
     * 新增优惠配置
     * 
     * @param disRule 优惠配置
     * @return 结果
     */
    public int insertDisRule(DisRule disRule);

    /**
     * 修改优惠配置
     * 
     * @param disRule 优惠配置
     * @return 结果
     */
    public int updateDisRule(DisRule disRule);

    /**
     * 批量删除优惠配置
     * 
     * @param disRuleIds 需要删除的优惠配置ID
     * @return 结果
     */
    public int deleteDisRuleByIds(Long[] disRuleIds);

    /**
     * 删除优惠配置信息
     * 
     * @param disRuleId 优惠配置ID
     * @return 结果
     */
    public int deleteDisRuleById(Long disRuleId);
}
