package com.boss.trainee_sailer_service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.trainee_sailer_service.entity.dto.WeeklyReportMissionsDetailsDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeeklyReportMissionsDetailsMapper extends BaseMapper<WeeklyReportMissionsDetailsDTO> {

    @Select("SELECT * FROM weekly_report_missions_details where weekly_report_id = #{weeklyReportId} AND mission_completed = 1 AND status = 1")
    List<WeeklyReportMissionsDetailsDTO> selectCompeleted(int weeklyReportId);

    @Select("SELECT * FROM weekly_report_missions_details where weekly_report_id = #{weeklyReportId} AND mission_completed = 0 AND status = 1")
    List<WeeklyReportMissionsDetailsDTO> selectUncompeleted(int weeklyReportId);

    @Select("SELECT project_name FROM project_plan WHERE project_id = #{projectId}")
    String getProjectName(Integer projectId);
}
