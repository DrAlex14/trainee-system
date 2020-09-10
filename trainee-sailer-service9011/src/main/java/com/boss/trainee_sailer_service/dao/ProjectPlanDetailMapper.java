package com.boss.trainee_sailer_service.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.trainee_sailer_service.entity.dto.ProjectPlanDTO;
import com.boss.trainee_sailer_service.entity.dto.ProjectPlanDetailDTO;
import org.springframework.stereotype.Repository;

/**
 * 项目计划详情持久层
 * author:张卓毅
 */

@Repository
public interface ProjectPlanDetailMapper extends BaseMapper<ProjectPlanDetailDTO> {
}
