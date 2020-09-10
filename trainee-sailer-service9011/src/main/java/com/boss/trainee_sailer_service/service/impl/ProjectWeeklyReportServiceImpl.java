package com.boss.trainee_sailer_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boss.trainee_sailer_service.dao.ProjectWeeklyReportMapper;
import com.boss.trainee_sailer_service.dao.WeeklyReportMissionsDetailsMapper;
import com.boss.trainee_sailer_service.entity.dto.ProjectWeeklyReportDTO;
import com.boss.trainee_sailer_service.entity.dto.WeeklyReportMissionsDetailsDTO;
import com.boss.trainee_sailer_service.entity.vo.ProjectWeeklyReportVO;
import com.boss.trainee_sailer_service.exception.MyException;
import com.boss.trainee_sailer_service.service.ProjectWeeklyReportService;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class ProjectWeeklyReportServiceImpl extends ServiceImpl<ProjectWeeklyReportMapper, ProjectWeeklyReportDTO> implements ProjectWeeklyReportService {

    @Resource
    private ProjectWeeklyReportMapper projectWeeklyReportMapper;

    @Resource
    private WeeklyReportMissionsDetailsMapper weeklyReportMissionsDetailsMapper;

    @Override
    public List<ProjectWeeklyReportVO> queryAll() throws MyException {
        try{
            List<ProjectWeeklyReportDTO> projectWeeklyReportDTOList = projectWeeklyReportMapper.selectList(null);
            List<ProjectWeeklyReportVO> projectWeeklyReportVOList = new ArrayList<ProjectWeeklyReportVO>();
            for(ProjectWeeklyReportDTO projectWeeklyReportDTO : projectWeeklyReportDTOList){
                ProjectWeeklyReportVO projectWeeklyReportVO = new ProjectWeeklyReportVO();
                BeanUtils.copyProperties(projectWeeklyReportDTO,projectWeeklyReportVO);
                projectWeeklyReportVOList.add(projectWeeklyReportVO);
            }
            return projectWeeklyReportVOList;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int insert(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException {
        try{
            ProjectWeeklyReportDTO projectWeeklyReportDTO = new ProjectWeeklyReportDTO();
            BeanUtils.copyProperties(projectWeeklyReportVO,projectWeeklyReportDTO);
            int result = projectWeeklyReportMapper.insert(projectWeeklyReportDTO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public ProjectWeeklyReportVO queryById(ProjectWeeklyReportVO projectWeeklyReportVO) throws MyException {
        try{
            ProjectWeeklyReportDTO projectWeeklyReportDTO = projectWeeklyReportMapper.selectById(projectWeeklyReportVO.getWeeklyReportId());
            ProjectWeeklyReportVO projectWeeklyReportVO1 = new ProjectWeeklyReportVO();
            BeanUtils.copyProperties(projectWeeklyReportDTO,projectWeeklyReportVO1);
            return projectWeeklyReportVO1;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int deleteById(ProjectWeeklyReportDTO projectWeeklyReportDTO) throws MyException {
        try{
            int result = projectWeeklyReportMapper.deleteReport(projectWeeklyReportDTO.getWeeklyReportId());
            result = projectWeeklyReportMapper.deleteMissions(); //逻辑删除项目已删除的任务
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int updateReportById(ProjectWeeklyReportDTO projectWeeklyReportDTO) throws MyException {
        try{
            int result = projectWeeklyReportMapper.updateById(projectWeeklyReportDTO);
            return result;
        }catch (Exception e){
            throw new MyException(400,"失败");
        }
    }

    @Override
    public int exportExcelByModel(int weeklyReportId) {
        ProjectWeeklyReportDTO projectWeeklyReportDTO = projectWeeklyReportMapper.selectById(weeklyReportId);
        List<WeeklyReportMissionsDetailsDTO> weeklyReportMissionsDetailsDTOListCompleted = weeklyReportMissionsDetailsMapper.selectCompeleted(weeklyReportId);
        List<WeeklyReportMissionsDetailsDTO> weeklyReportMissionsDetailsDTOListUncompleted = weeklyReportMissionsDetailsMapper.selectUncompeleted(weeklyReportId);
        String projectName = weeklyReportMissionsDetailsMapper.getProjectName(projectWeeklyReportDTO.getProjectId());
        //日志测试
        log.info(projectWeeklyReportDTO);
        log.info(weeklyReportMissionsDetailsDTOListCompleted);
        log.info(weeklyReportMissionsDetailsDTOListUncompleted);

        try{
            String PATH = "D:\\素材弹药库\\个人周报.xlsx";
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("./trainee-system/trainee-sailer-service9011/src/main/resources/static/博思启航生项目实训个人周报模板.xlsx"));
            XSSFSheet sheet = wb.getSheet("Sheet1");
            XSSFRow row0 = sheet.getRow(0);
            XSSFCell cell01 = row0.getCell(1);
            cell01.setCellValue(projectWeeklyReportDTO.getStartDate() + "~" + projectWeeklyReportDTO.getEndDate());
            XSSFCell cell09 = row0.getCell(9);
            cell09.setCellValue(projectName);

            XSSFRow row2 = sheet.getRow(2);
            XSSFCell cell20 = row2.getCell(0);
            cell20.setCellValue(projectWeeklyReportDTO.getProjectProblem());

            XSSFRow row5 = sheet.getRow(5);
            XSSFCell cell51 = row5.getCell(1);
            cell51.setCellValue(projectWeeklyReportDTO.getPlanCompleteness());
            XSSFCell cell54 = row5.getCell(4);

            XSSFCell cell56 = row5.getCell(6);
            cell56.setCellValue(projectWeeklyReportDTO.getProjectAnalysis());

            XSSFRow row6 = sheet.getRow(6);
            XSSFCell cell61 = row6.getCell(1);
            cell61.setCellValue(projectWeeklyReportDTO.getRealCompleteness());

            //计算属性
            XSSFRow row7 = sheet.getRow(7);
            XSSFCell cell71 = row7.getCell(1);
            cell71.setCellValue(cell51.getNumericCellValue() - cell61.getNumericCellValue());
            cell54.setCellValue(cell61.getNumericCellValue()/cell51.getNumericCellValue());

            for(int i = 0; i < weeklyReportMissionsDetailsDTOListCompleted.size();i++){
                XSSFRow row = sheet.getRow(i+10);
                XSSFCell cell1 = row.getCell(1);
                cell1.setCellValue(weeklyReportMissionsDetailsDTOListCompleted.get(i).getMissionId());
                XSSFCell cell8 = row.getCell(8);
                cell8.setCellValue(weeklyReportMissionsDetailsDTOListCompleted.get(i).getWorkload());
                XSSFCell cell9 = row.getCell(9);
                cell9.setCellValue(weeklyReportMissionsDetailsDTOListCompleted.get(i).getAchievement());
                XSSFCell cell12 = row.getCell(12);
                cell12.setCellValue(weeklyReportMissionsDetailsDTOListCompleted.get(i).getRemark());
            }
            for(int i = 0; i < weeklyReportMissionsDetailsDTOListUncompleted.size();i++){
                XSSFRow row = sheet.getRow(i+22);
                XSSFCell cell1 = row.getCell(1);
                cell1.setCellValue(weeklyReportMissionsDetailsDTOListUncompleted.get(i).getMissionId());
                XSSFCell cell8 = row.getCell(8);
                cell8.setCellValue(weeklyReportMissionsDetailsDTOListUncompleted.get(i).getCompleteness());
                XSSFCell cell9 = row.getCell(9);
                cell9.setCellValue(weeklyReportMissionsDetailsDTOListUncompleted.get(i).getRemark());
            }
            wb.write(new FileOutputStream(PATH));
            wb.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }


}
