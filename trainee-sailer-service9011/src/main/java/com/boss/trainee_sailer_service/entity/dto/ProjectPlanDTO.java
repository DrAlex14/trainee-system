package com.boss.trainee_sailer_service.entity.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@TableName(value = "project_plan")
public class ProjectPlanDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    //项目编号
    @TableId(type = IdType.AUTO)
    private Integer projectId;

    //班级编号
    private Integer classId;

    //项目名称
    private String projectName;

    //项目计划开始时间
    private Date planStartTime;

    //项目计划结束时间
    private Date planFinishTime;

    //实际项目开始时间
    private Date realStartTime;

    //实际项目结束时间
    private Date realFinishTime;

    //创建时间
    private Timestamp createTime;

    //修改时间
    private Timestamp updateTime;

    //版本 实现乐观锁,修改时携带version值
    @Version
    private Integer version;

    //最后修改者编号
    private Integer updaterId;

    //状态 做逻辑删除    1为正常,0为逻辑删除
    @TableLogic
    private Integer status;

    //创建数据者编号
    private Integer creatorId;
}
