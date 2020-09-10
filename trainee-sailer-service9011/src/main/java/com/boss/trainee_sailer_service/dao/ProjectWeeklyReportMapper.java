package com.boss.trainee_sailer_service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.trainee_sailer_service.entity.dto.ProjectWeeklyReportDTO;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectWeeklyReportMapper extends BaseMapper<ProjectWeeklyReportDTO> {

    @Update("UPDATE project_weekly_report set\n" +
            "project_weekly_report.`status` = 0 WHERE weekly_report_id = #{weeklyReportId}")
    int deleteReport(Integer weeklyReportId);

    @Update("UPDATE weekly_report_missions_details SET `status` = 0 WHERE weekly_report_id = (SELECT weekly_report_id FROM project_weekly_report WHERE `status` = 0)")
    int deleteMissions();
}
