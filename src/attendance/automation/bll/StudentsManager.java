/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.bll;

import attendance.automation.be.Students;
import attendance.automation.be.Teachers;
import attendance.automation.dal.AttendanceDAO;
import java.util.List;

/**
 *
 * @author Jens Karlskov
 */
public class StudentsManager
{
     AttendanceDAO attendanceDAO = new AttendanceDAO();
    
    
     /**
     * En liste af alle employees i databasen
     *
     * @return
     */
    public List<Students> getAllStudents()
    {
        return attendanceDAO.getAllStudents();
    }

    public List<Teachers> getAllTeachers()
    {
        return attendanceDAO.getAllTeachers();
    }
}
