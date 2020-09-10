package com.boss.trainee_sailer_service.controller;

import com.alibaba.excel.EasyExcel;
import com.boss.trainee_sailer_service.entity.CommonResult;
import com.boss.trainee_sailer_service.entity.vo.ProjectPlanVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.ProjectPlanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 项目计划
 * author: 张卓毅
 */
@RestController
@Log4j2
@RequestMapping("/api/projectPlans")
public class ProjectPlanController {

    @Resource
    private ProjectPlanService projectPlanService;

    //用Id查询单条信息
    @PostMapping("/queryById")
    public CommonResult<ProjectPlanVO> queryById(ProjectPlanVO projectPlanVO) throws MyException {
        ProjectPlanVO projectPlanVO1 = projectPlanService.queryById(projectPlanVO);
        Optional.ofNullable(projectPlanVO1)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<ProjectPlanVO>(200,"查询成功",projectPlanVO1);
    }

    //查询所有信息
    @GetMapping
    public CommonResult<List<ProjectPlanVO>> queryAll() throws MyException {
        List<ProjectPlanVO> projectPlanVOList = projectPlanService.queryAll();
        Optional.ofNullable(projectPlanVOList)
                .filter( res -> projectPlanVOList.size() != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<List<ProjectPlanVO>>(200,"查询成功",projectPlanVOList);
    }

    @PostMapping
    public CommonResult<Integer> insert(ProjectPlanVO projectPlanVO) throws MyException {
        int result = projectPlanService.insert(projectPlanVO);
        Optional.ofNullable(result)
                .filter( res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(201,"插入成功",result);
    }

    @PatchMapping
    public CommonResult<Integer> updateById(ProjectPlanVO projectPlanVO) throws MyException {
        int result = projectPlanService.update(projectPlanVO);
        Optional.ofNullable(result)
                .filter( res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(201,"修改成功",result);
    }

    @DeleteMapping
    public CommonResult<Integer> deleteById(ProjectPlanVO projectPlanVO) throws MyException {
        int result = projectPlanService.deleteById(projectPlanVO);
        Optional.ofNullable(result)
                .filter(res -> result !=0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(201,"删除成功",result);
    }

    /**
     *项目计划表Excel导出
     * @return
     * @throws MyException
     */
    @GetMapping("/OutByExcel")
    public CommonResult<Integer> outFileByExcel() throws MyException {
        String PATH = "D:\\素材弹药库\\项目计划表.xlsx";
        List<ProjectPlanVO> projectPlanVOList = projectPlanService.queryAll();
        Optional.ofNullable(projectPlanVOList)
                .filter(res -> projectPlanVOList.size() != 0)
                .orElseThrow(() -> new MyException(400,"失败"));
        try{
            String filename = PATH;
            EasyExcel.write(filename,ProjectPlanVO.class).sheet("工作表").doWrite(projectPlanVOList);
            return new CommonResult<Integer>(200,"导出成功",1);
        }catch (Exception e){
            throw new MyException(400,"导出失败");
        }
    }
}
