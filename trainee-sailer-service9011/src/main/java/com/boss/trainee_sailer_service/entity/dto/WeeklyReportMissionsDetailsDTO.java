package com.boss.trainee_sailer_service.entity.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@TableName(value = "weekly_report_missions_details")
public class WeeklyReportMissionsDetailsDTO {

    //序号
    @TableId(type = IdType.AUTO)
    private Integer number;

    //周报编号
    private Integer weeklyReportId;

    //任务编号
    private Integer missionId;

    //任务是否完成标记
    private Integer missionCompleted;

    //任务完成度
    private double completeness;

    //工作量
    private String workload;

    //成果
    private String achievement;

    //备注
    private String remark;

    //创建时间
    private Timestamp createTime;

    //修改时间
    private Timestamp updateTime;

    //版本 实现乐观锁
    @Version
    private Integer version;

    //最后修改者编号
    private Integer updaterId;

    //状态 做逻辑删除
    @TableLogic
    private Integer status;

    //创建数据者编号
    private Integer creatorId;
}
