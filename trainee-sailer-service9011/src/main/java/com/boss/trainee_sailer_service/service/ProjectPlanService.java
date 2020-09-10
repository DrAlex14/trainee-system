package com.boss.trainee_sailer_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boss.trainee_sailer_service.entity.dto.ProjectPlanDTO;
import com.boss.trainee_sailer_service.entity.vo.ProjectPlanVO;
import com.boss.trainee_sailer_service.exception.MyException;

import java.util.List;

public interface ProjectPlanService extends IService<ProjectPlanDTO>{

    int insert(ProjectPlanVO projectPlanVO) throws MyException;

    List<ProjectPlanVO> queryAll() throws MyException;

    int update(ProjectPlanVO projectPlanVO) throws MyException;

    int deleteById(ProjectPlanVO projectPlanVO) throws MyException;

    ProjectPlanVO queryById(ProjectPlanVO projectPlanVO) throws MyException;

}
