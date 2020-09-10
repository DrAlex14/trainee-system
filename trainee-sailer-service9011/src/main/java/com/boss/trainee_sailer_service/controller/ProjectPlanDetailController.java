package com.boss.trainee_sailer_service.controller;

import com.alibaba.excel.EasyExcel;
import com.boss.trainee_sailer_service.entity.CommonResult;
import com.boss.trainee_sailer_service.entity.vo.ProjectPlanDetailVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.ProjectPlanDetailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 项目计划任务详情
 * @author 张卓毅
 */
@RestController
@Log4j2
@RequestMapping("/api/projectPlanDetail")
public class ProjectPlanDetailController {

    @Resource
    private ProjectPlanDetailService projectPlanDetailService;

    @PostMapping
    public CommonResult<Integer> insert(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        int result = projectPlanDetailService.insert(projectPlanDetailVO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(201,"插入成功",result);
    }

    @GetMapping
    public CommonResult<List<ProjectPlanDetailVO>> queryAll() throws MyException {
        List<ProjectPlanDetailVO> projectPlanDetailVOList = projectPlanDetailService.queryAll();
        Optional.ofNullable(projectPlanDetailVOList)
                .filter(res -> projectPlanDetailVOList.size() != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<List<ProjectPlanDetailVO>>(200,"查询成功",projectPlanDetailVOList);
    }

    @DeleteMapping
    public CommonResult<Integer> deleteById(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        int result = projectPlanDetailService.deleteById(projectPlanDetailVO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(201,"删除成功",result);
    }

    @PatchMapping
    public CommonResult<Integer> update(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        int result = projectPlanDetailService.update(projectPlanDetailVO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(201,"修改成功",result);
    }

    @PostMapping("/queryById")
    public CommonResult<ProjectPlanDetailVO> queryById(ProjectPlanDetailVO projectPlanDetailVO) throws MyException {
        ProjectPlanDetailVO projectPlanDetailVO1 = projectPlanDetailService.queryById(projectPlanDetailVO);
        Optional.ofNullable(projectPlanDetailVO)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<ProjectPlanDetailVO>(200,"查询成功",projectPlanDetailVO1);
    }

    @GetMapping("/OutByExcel")
    public CommonResult<Integer> outFileByExcel(Integer project_id) throws MyException {
        String PATH = "D:\\素材弹药库\\";
        List<ProjectPlanDetailVO> projectPlanDetailVOList = projectPlanDetailService.queryMissions(project_id);
        Optional.ofNullable(projectPlanDetailVOList)
                .filter(res -> projectPlanDetailVOList.size() != 0)
                .orElseThrow(() -> new MyException(400,"失败"));
        try{
            String filename = PATH + "项目计划详情表.xls";
            EasyExcel.write(filename,ProjectPlanDetailVO.class).sheet("工作表").doWrite(projectPlanDetailVOList);
            return new CommonResult<Integer>(200,"导出成功",1);
        }catch (Exception e){
            throw new MyException(400,"导出失败");
        }
    }
}
