package com.boss.trainee_sailer_service.controller;

import com.boss.trainee_sailer_service.entity.CommonResult;
import com.boss.trainee_sailer_service.entity.dto.WeeklyReportMissionsDetailsDTO;
import com.boss.trainee_sailer_service.entity.vo.WeeklyReportMissionsDetailsVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.WeeklyReportMissionsDetailsService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/weeklyReportMissionsDetails")
@Log4j2
public class WeeklyReportMissionsDetailsController {

    @Resource
    private WeeklyReportMissionsDetailsService weeklyReportMissionsDetailsService;

    //获取全部周报任务
    @GetMapping
    public CommonResult<List<WeeklyReportMissionsDetailsVO>> queryAll() throws MyException {
        List<WeeklyReportMissionsDetailsDTO> weeklyReportMissionsDetailsDTOList = weeklyReportMissionsDetailsService.queryAll();
        List<WeeklyReportMissionsDetailsVO> weeklyReportMissionsDetailsVOList = new ArrayList<WeeklyReportMissionsDetailsVO>();
        for(WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO : weeklyReportMissionsDetailsDTOList){
            WeeklyReportMissionsDetailsVO weeklyReportMissionsDetailsVO = new WeeklyReportMissionsDetailsVO();
            BeanUtils.copyProperties(weeklyReportMissionsDetailsDTO,weeklyReportMissionsDetailsVO);
            weeklyReportMissionsDetailsVOList.add(weeklyReportMissionsDetailsVO);
        }
        Optional.ofNullable(weeklyReportMissionsDetailsVOList)
                .filter(res -> weeklyReportMissionsDetailsVOList.size() != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<List<WeeklyReportMissionsDetailsVO>>(200,"查找成功",weeklyReportMissionsDetailsVOList);
    }

    @PostMapping
    public CommonResult<Integer> insert(WeeklyReportMissionsDetailsVO weeklyReportMissionsDetailsVO) throws MyException {
        WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO = new WeeklyReportMissionsDetailsDTO();
        BeanUtils.copyProperties(weeklyReportMissionsDetailsVO,weeklyReportMissionsDetailsDTO);
        int result = weeklyReportMissionsDetailsService.insert(weeklyReportMissionsDetailsDTO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(200,"插入成功",result);
    }

    @DeleteMapping
    public CommonResult<Integer> delete(WeeklyReportMissionsDetailsVO weeklyReportMissionsDetailsVO) throws MyException {
        WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO = new WeeklyReportMissionsDetailsDTO();
        BeanUtils.copyProperties(weeklyReportMissionsDetailsVO,weeklyReportMissionsDetailsDTO);
        int result = weeklyReportMissionsDetailsService.delete(weeklyReportMissionsDetailsDTO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(200,"删除成功",result);
    }

    @PatchMapping
    public CommonResult<Integer> update(WeeklyReportMissionsDetailsVO weeklyReportMissionsDetailsVO) throws MyException {
        WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO = new WeeklyReportMissionsDetailsDTO();
        BeanUtils.copyProperties(weeklyReportMissionsDetailsVO,weeklyReportMissionsDetailsDTO);
        int result = weeklyReportMissionsDetailsService.updateMission(weeklyReportMissionsDetailsDTO);
        Optional.ofNullable(result)
                .filter(res -> result != 0)
                .orElseThrow(() -> new MyException(404,"不存在"));
        return new CommonResult<Integer>(200,"修改成功",result);
    }

}
