package com.boss.trainee_sailer_service.service;

import com.boss.trainee_sailer_service.entity.vo.ProjectPlanDetailVO;
import com.boss.trainee_sailer_service.exception.MyException;

import java.util.List;

public interface ProjectPlanDetailService {

    int insert(ProjectPlanDetailVO projectPlanVO) throws MyException;

    List<ProjectPlanDetailVO> queryAll() throws MyException;

    int deleteById(ProjectPlanDetailVO projectPlanDetailVO) throws MyException;

    int update(ProjectPlanDetailVO projectPlanDetailVO) throws MyException;

    ProjectPlanDetailVO queryById(ProjectPlanDetailVO projectPlanDetailVO) throws MyException;

    List<ProjectPlanDetailVO> queryMissions(int projectId) throws MyException;
}
