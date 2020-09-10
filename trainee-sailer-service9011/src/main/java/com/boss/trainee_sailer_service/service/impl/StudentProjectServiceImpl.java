package com.boss.trainee_sailer_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boss.trainee_sailer_service.dao.StudentProjectMapper;
import com.boss.trainee_sailer_service.entity.dto.StudentProjectDTO;
import com.boss.trainee_sailer_service.entity.vo.StudentProjectVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.StudentProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentProjectServiceImpl extends ServiceImpl<StudentProjectMapper, StudentProjectDTO> implements StudentProjectService {

    @Resource
    private StudentProjectMapper studentProjectMapper;


    @Override
    public List<StudentProjectVO> queryAll() throws MyException {
        try{
            List<StudentProjectVO> studentProjectVOList = new ArrayList<StudentProjectVO>();
            List<StudentProjectDTO> studentProjectDTOList = studentProjectMapper.selectList(null);
            for(StudentProjectDTO studentProjectDTO : studentProjectDTOList){
                StudentProjectVO studentProjectVO = new StudentProjectVO();
                BeanUtils.copyProperties(studentProjectDTO,studentProjectVO);
                studentProjectVOList.add(studentProjectVO);
            }
            return studentProjectVOList;
        }catch (Exception e){
            throw new MyException(400,"不存在");
        }
    }
}
