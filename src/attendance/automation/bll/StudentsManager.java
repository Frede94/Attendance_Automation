/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.bll;

import attendance.automation.be.Students;
import attendance.automation.be.Teachers;
import attendance.automation.dal.AttendanceDAO;
import attendance.automation.gui.CorrectWindowController;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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

    public void login(String password, String email)
    {
        attendanceDAO.getAllLogins2(password, email);
    }

    public void loginCheck(String password, String email, CorrectWindowController cwc, Parent root1, FXMLLoader fxmlLoader)
    {
        attendanceDAO.getAllLogins(password, email, cwc, root1, fxmlLoader);
    }
}
