package com.boss.trainee_sailer_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boss.trainee_sailer_service.dao.ProjectPlanDetailMapper;
import com.boss.trainee_sailer_service.entity.dto.ProjectPlanDetailDTO;
import com.boss.trainee_sailer_service.entity.vo.ProjectPlanDetailVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.ProjectPlanDetailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目计划的任务详细
 * @author 张卓毅
 */
@Service
@Log4j2
public class ProjectPlanDetailServiceImpl implements ProjectPlanDetailService{

    @Resource
    private ProjectPlanDetailMapper projectPlanDetailMapper;

    @Override
    public int insert(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        try{
        ProjectPlanDetailDTO projectPlanDetailDTO = new ProjectPlanDetailDTO();
        BeanUtils.copyProperties(projectPlanDetailVO,projectPlanDetailDTO);
        log.info(projectPlanDetailDTO);
        log.info(projectPlanDetailVO);

            int result = projectPlanDetailMapper.insert(projectPlanDetailDTO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public List<ProjectPlanDetailVO> queryAll() throws MyException {
        try {
            List<ProjectPlanDetailDTO> projectPlanDetailDTOList = projectPlanDetailMapper.selectList(null);
            List<ProjectPlanDetailVO> projectPlanDetailVOList = new ArrayList<ProjectPlanDetailVO>();
            for(ProjectPlanDetailDTO projectPlanDetailDTO : projectPlanDetailDTOList){
                ProjectPlanDetailVO projectPlanDetailVO = new ProjectPlanDetailVO();
                BeanUtils.copyProperties(projectPlanDetailDTO,projectPlanDetailVO);
                projectPlanDetailVOList.add(projectPlanDetailVO);
            }
            return projectPlanDetailVOList;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int deleteById(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        try{
            int result = projectPlanDetailMapper.deleteById(projectPlanDetailVO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int update(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        ProjectPlanDetailDTO projectPlanDetailDTO = new ProjectPlanDetailDTO();
        BeanUtils.copyProperties(projectPlanDetailVO,projectPlanDetailDTO);
        log.info(projectPlanDetailDTO);
        log.info(projectPlanDetailVO);
        try{
            int result = projectPlanDetailMapper.updateById(projectPlanDetailDTO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public ProjectPlanDetailVO queryById(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        try{
            ProjectPlanDetailDTO projectPlanDetailDTO = projectPlanDetailMapper.selectById(projectPlanDetailVO);
            ProjectPlanDetailVO projectPlanDetailVO1 = new ProjectPlanDetailVO();
            BeanUtils.copyProperties(projectPlanDetailDTO,projectPlanDetailVO1);
            return projectPlanDetailVO1;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public List<ProjectPlanDetailVO> queryMissions(int project_id) throws MyException {
        try{
            QueryWrapper querywrapper = new QueryWrapper();
            querywrapper.eq("project_id",project_id);
            List<ProjectPlanDetailVO> projectPlanDetailVOList = projectPlanDetailMapper.selectList(querywrapper);
            return projectPlanDetailVOList;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }


}
