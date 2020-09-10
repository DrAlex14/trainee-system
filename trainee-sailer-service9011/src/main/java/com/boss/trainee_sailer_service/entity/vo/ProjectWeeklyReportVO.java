package com.boss.trainee_sailer_service.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class ProjectWeeklyReportVO {

    private Integer weeklyReportId;

    private Integer projectId;

    private Integer workerId;

    private Date startDate;

    private Date endDate;

    private double planCompleteness;

    private double realCompleteness;

    private String projectProblem;

    private String projectAnalysis;

    //创建时间
    private Timestamp createTime;

    //修改时间
    private Timestamp updateTime;

    //版本 实现乐观锁
    private Integer version;

    //最后修改者编号
    private Integer updaterId;

    //状态 做逻辑删除
    private Integer status;

    //创建数据者编号
    private Integer creatorId;

}
