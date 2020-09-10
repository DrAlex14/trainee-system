package com.boss.trainee_sailer_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boss.trainee_sailer_service.entity.dto.ProjectWeeklyReportDTO;
import com.boss.trainee_sailer_service.entity.vo.ProjectWeeklyReportVO;
import com.boss.trainee_sailer_service.exception.MyException;

import java.util.List;

public interface ProjectWeeklyReportService extends IService<ProjectWeeklyReportDTO> {
    List<ProjectWeeklyReportVO> queryAll() throws MyException;

    int insert(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException;

    ProjectWeeklyReportVO queryById(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException;

    int deleteById(ProjectWeeklyReportDTO projectWeeklyReportDTO) throws MyException;

    int updateReportById(ProjectWeeklyReportDTO projectWeeklyReportDTO) throws MyException;

    int exportExcelByModel(int weeklyReportId);
}
