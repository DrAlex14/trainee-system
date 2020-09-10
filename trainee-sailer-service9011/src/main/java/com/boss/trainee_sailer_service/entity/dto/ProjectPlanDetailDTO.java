package com.boss.trainee_sailer_service.entity.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@TableName(value = "project_plan_detail")
public class ProjectPlanDetailDTO implements Serializable {

    //任务编号
    @TableId(type = IdType.AUTO)
    private Integer missionId;

    //所属项目的编号，关联于project_plan表的project_id
    private Integer projectId;

    //描述任务的细节
    private String missionDetail;

    //创建时间
    private Timestamp createTime;

    //修改时间
    private Timestamp updateTime;

    //版本 实现乐观锁
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
