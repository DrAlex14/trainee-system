package com.boss.trainee_sailer_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boss.trainee_sailer_service.dao.ProjectPlanMapper;
import com.boss.trainee_sailer_service.entity.dto.ProjectPlanDTO;
import com.boss.trainee_sailer_service.entity.vo.ProjectPlanVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.ProjectPlanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ProjectPlanServiceImpl extends ServiceImpl<ProjectPlanMapper,ProjectPlanDTO> implements ProjectPlanService{

    @Resource
    private ProjectPlanMapper projectPlanMapper;

    @Override
    public int insert(ProjectPlanVO projectPlanVO) throws MyException {
        try{
            ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
            BeanUtils.copyProperties(projectPlanVO,projectPlanDTO);
            log.info(projectPlanDTO);
            log.info(projectPlanVO);
            return projectPlanMapper.insert(projectPlanDTO);
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public List<ProjectPlanVO> queryAll() throws MyException {
        try{
            List<ProjectPlanDTO> projectPlanDTOList = projectPlanMapper.selectList(null);
            List<ProjectPlanVO> projectPlanVOList = new ArrayList<ProjectPlanVO>();
            for(ProjectPlanDTO projectPlanDTO : projectPlanDTOList){
                ProjectPlanVO projectPlanVO = new ProjectPlanVO();
                BeanUtils.copyProperties(projectPlanDTO,projectPlanVO);
                projectPlanVOList.add(projectPlanVO);
            }
            return projectPlanVOList;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int update(ProjectPlanVO projectPlanVO) throws MyException {
        try{
            ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
            log.info(projectPlanVO);
            BeanUtils.copyProperties(projectPlanVO,projectPlanDTO);
            log.info(projectPlanDTO);
            int result = projectPlanMapper.updateById(projectPlanDTO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int deleteById(ProjectPlanVO projectPlanVO) throws MyException {
        try{
            int result = projectPlanMapper.deleteById(projectPlanVO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public ProjectPlanVO queryById(ProjectPlanVO projectPlanVO) throws MyException {
        try{
            ProjectPlanDTO projectPlanDTO = projectPlanMapper.selectById(projectPlanVO);
            ProjectPlanVO projectPlanVO1 = new ProjectPlanVO();
            BeanUtils.copyProperties(projectPlanDTO,projectPlanVO1);

            return projectPlanVO1;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }
}
