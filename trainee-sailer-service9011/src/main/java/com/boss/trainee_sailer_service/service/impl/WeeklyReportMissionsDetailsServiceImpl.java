package com.boss.trainee_sailer_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boss.trainee_sailer_service.dao.WeeklyReportMissionsDetailsMapper;
import com.boss.trainee_sailer_service.entity.dto.WeeklyReportMissionsDetailsDTO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.WeeklyReportMissionsDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WeeklyReportMissionsDetailsServiceImpl extends ServiceImpl<WeeklyReportMissionsDetailsMapper, WeeklyReportMissionsDetailsDTO> implements WeeklyReportMissionsDetailsService {

    @Resource
    private WeeklyReportMissionsDetailsMapper weeklyReportMissionsDetailsMapper;


    @Override
    public List<WeeklyReportMissionsDetailsDTO> queryAll() throws MyException {
        try{
            List<WeeklyReportMissionsDetailsDTO> weeklyReportMissionsDetailsDTOList = weeklyReportMissionsDetailsMapper.selectList(null);
            return weeklyReportMissionsDetailsDTOList;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int insert(WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO) throws MyException {
        try {
            int result = weeklyReportMissionsDetailsMapper.insert(weeklyReportMissionsDetailsDTO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int delete(WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO) throws MyException {
        try{
            int result = weeklyReportMissionsDetailsMapper.deleteById(weeklyReportMissionsDetailsDTO.getWeeklyReportId());
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int updateMission(WeeklyReportMissionsDetailsDTO weeklyReportMissionsDetailsDTO) throws MyException {
        try{
            int result = weeklyReportMissionsDetailsMapper.updateById(weeklyReportMissionsDetailsDTO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }
}
