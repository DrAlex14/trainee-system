package com.boss.trainee_sailer_service.entity.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.date.DateStringConverter;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@TableName(value = "project_plan_detail")
public class ProjectPlanDetailVO implements Serializable {

    //任务编号
    @ExcelProperty(value = "任务编号")
    private Integer missionId;

    //所属项目的编号，关联于project_plan表的project_id
    @ExcelProperty(value = "项目编号")
    private Integer projectId;

    //描述任务的细节
    @ExcelProperty(value = "任务细节描述")
    private String missionDetail;

    //创建时间
    @ExcelProperty(value = "创建时间",converter = DateStringConverter.class)
    private Timestamp createTime;

    //修改时间
    @ExcelProperty(value = "修改时间",converter = DateStringConverter.class)
    private Timestamp updateTime;

    //版本 实现乐观锁
    @ExcelIgnore
    private Integer version;

    //最后修改者编号
    @ExcelProperty(value = "修改人编号")
    private Integer updaterId;

    //状态 做逻辑删除    1为正常,0为逻辑删除
    @ExcelIgnore
    private Integer status;

    //创建数据者编号
    @ExcelProperty(value = "创建人编号")
    private Integer creatorId;
}

