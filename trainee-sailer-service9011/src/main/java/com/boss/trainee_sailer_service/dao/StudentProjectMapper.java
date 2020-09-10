package com.boss.trainee_sailer_service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boss.trainee_sailer_service.entity.dto.StudentProjectDTO;
import org.springframework.stereotype.Repository;

/**
 * 学生项目表管理
 * @author 张卓毅
 */
@Repository
public interface StudentProjectMapper extends BaseMapper<StudentProjectDTO> {
}
