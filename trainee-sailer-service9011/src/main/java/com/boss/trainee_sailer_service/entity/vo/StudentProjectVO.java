package com.boss.trainee_sailer_service.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class StudentProjectVO {

    private Integer number;

    private Integer workerId;

    private Integer projectId;

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
