package com.boss.trainee_sailer_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boss.trainee_sailer_service.entity.dto.StudentProjectDTO;
import com.boss.trainee_sailer_service.entity.vo.StudentProjectVO;
import com.boss.trainee_sailer_service.exception.MyException;

import java.util.List;

public interface StudentProjectService extends IService<StudentProjectDTO> {

    List<StudentProjectVO> queryAll() throws MyException;
}
