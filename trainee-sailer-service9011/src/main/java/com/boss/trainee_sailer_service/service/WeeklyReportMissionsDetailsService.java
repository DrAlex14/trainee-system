package com.boss.trainee_sailer_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boss.trainee_sailer_service.entity.dto.WeeklyReportMissionsDetailsDTO;
import com.boss.trainee_sailer_service.exception.MyException;

import java.util.List;

public interface WeeklyReportMissionsDetailsService extends IService<WeeklyReportMissionsDetailsDTO> {
    List<WeeklyReportMissionsDetailsDTO> queryAll() throws MyException;

    int insert(WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO) throws MyException;

    int delete(WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO) throws MyException;

    int updateMission(WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO) throws MyException;
}
