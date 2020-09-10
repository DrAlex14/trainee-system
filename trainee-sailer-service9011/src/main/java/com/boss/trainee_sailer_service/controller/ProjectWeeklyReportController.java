package com.boss.trainee_sailer_service.controller;

import com.boss.trainee_sailer_service.entity.CommonResult;
import com.boss.trainee_sailer_service.entity.dto.ProjectWeeklyReportDTO;
import com.boss.trainee_sailer_service.entity.vo.ProjectWeeklyReportVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.ProjectWeeklyReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projectWeeklyReport")
public class ProjectWeeklyReportController {

    @Resource
    private ProjectWeeklyReportService projectWeeklyReportService;

    @GetMapping
    public CommonResult<List<ProjectWeeklyReportVO>> queryAll() throws MyException {
        List<ProjectWeeklyReportVO> projectWeeklyReportVOList = projectWeeklyReportService.queryAll();
        Optional.ofNullable(projectWeeklyReportVOList)
                .filter(res -> projectWeeklyReportVOList.size() != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<List<ProjectWeeklyReportVO>>(200,"查询成功",projectWeeklyReportVOList);
    }

    @PostMapping
    public CommonResult<Integer> Insert(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException {
        int result = projectWeeklyReportService.insert(projectWeeklyReportVO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(201,"添加成功",result);
    }

    @GetMapping("/queryById")
    public CommonResult<ProjectWeeklyReportVO> queryById(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException {
        ProjectWeeklyReportVO projectWeeklyReportVO1 = projectWeeklyReportService.queryById(projectWeeklyReportVO);
        Optional.ofNullable(projectWeeklyReportVO1)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<ProjectWeeklyReportVO>(200,"查找成功",projectWeeklyReportVO1);
    }

    @DeleteMapping
    public CommonResult<Integer> deleteById(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException {
        ProjectWeeklyReportDTO projectWeeklyReportDTO = new ProjectWeeklyReportDTO();
        BeanUtils.copyProperties(projectWeeklyReportVO,projectWeeklyReportDTO);
        int result = projectWeeklyReportService.deleteById(projectWeeklyReportDTO);
        Optional.ofNullable(result)
                .filter(res -> result !=0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(200,"删除成功",result);
    }

    @PatchMapping
    public CommonResult<Integer> updateById(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException {
        ProjectWeeklyReportDTO projectWeeklyReportDTO = new ProjectWeeklyReportDTO();
        BeanUtils.copyProperties(projectWeeklyReportVO,projectWeeklyReportDTO);
        int result = projectWeeklyReportService.updateReportById(projectWeeklyReportDTO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(200,"修改成功",result);
    }

    @PostMapping("/exportExcelByModel")
    public CommonResult<Integer> exportExcelByModel(int weeklyReportId) throws MyException {
        int result = projectWeeklyReportService.exportExcelByModel(weeklyReportId);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(200,"导出成功",result);
    }

}
