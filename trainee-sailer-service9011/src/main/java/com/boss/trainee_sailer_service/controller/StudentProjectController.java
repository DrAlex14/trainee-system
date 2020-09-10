package com.boss.trainee_sailer_service.controller;

import com.boss.trainee_sailer_service.entity.CommonResult;
import com.boss.trainee_sailer_service.entity.vo.ProjectPlanDetailVO;
import com.boss.trainee_sailer_service.entity.vo.StudentProjectVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.StudentProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@RequestMapping("/api/studentProject")
public class StudentProjectController {

    @Resource
    private StudentProjectService studentProjectService;

    @GetMapping
    public CommonResult<List<StudentProjectVO>> queryAll() throws MyException {
        List<StudentProjectVO> studentProjectVOList = studentProjectService.queryAll();
        Optional.ofNullable(studentProjectVOList)
                .filter(res -> studentProjectVOList.size() != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<List<StudentProjectVO>>(200,"查询成功",studentProjectVOList);
    }
}
