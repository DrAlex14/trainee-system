package com.boss.trainee_sailer_service.entity.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.date.DateStringConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * author:张卓毅
 * remark:项目计划的展示层实体类
 */
@Data
@NoArgsConstructor
public class ProjectPlanVO implements Serializable {

    //项目编号
    @ExcelProperty("项目编号")
    private Integer projectId;

    //班级编号
    @ExcelProperty("班级编号")
    private Integer classId;

    //项目名称
    @ExcelProperty("项目名称")
    private String projectName;

    //项目计划开始时间
    //@ExcelProperty("计划开始日期")
    @ExcelIgnore
    private Date planStartTime;

    //项目计划结束时间
    @ExcelProperty(value = "计划结束日期",converter = DateStringConverter.class)
    private Date planFinishTime;

    //实际项目开始时间
    @ExcelProperty(value = "实际开始日期",converter = DateStringConverter.class)
    private Date realStartTime;

    //实际项目结束时间
    @ExcelProperty(value = "实际结束日期",converter = DateStringConverter.class)
    private Date realFinishTime;

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
    @ExcelIgnore
    private Integer updaterId;

    //状态 做逻辑删除
    @ExcelIgnore
    private Integer status;

    //创建数据者编号
    @ExcelIgnore
    private Integer creatorId;
}
