/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.dal;

import attendance.automation.be.Students;
import attendance.automation.be.Teachers;
import attendance.automation.gui.CorrectWindowController;
import com.jfoenix.controls.JFXButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Jens Karlskov
 */
public class AttendanceDAO
{

    DataBaseConnector dbc = new DataBaseConnector();
    /**
     * get all student from the database
     * @return 
     */
    public List<Students> getAllStudents()
    {

        List<Students> students = new ArrayList();

        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM AttendanceStudents");
            while (rs.next())
            {
                Students currentAttendanceStudents = new Students();

                currentAttendanceStudents.setFirstName(rs.getString("FirstName"));
                currentAttendanceStudents.setLastName(rs.getString("LastName"));
                currentAttendanceStudents.setCity(rs.getString("City"));
                currentAttendanceStudents.setCountry(rs.getString("Country"));
                currentAttendanceStudents.setEmail(rs.getString("Email"));
                currentAttendanceStudents.setDBOS(rs.getInt("DBOS"));
                currentAttendanceStudents.setSCO(rs.getInt("SCO"));
                currentAttendanceStudents.setSDE(rs.getInt("SDE"));
                currentAttendanceStudents.setITO(rs.getInt("ITO"));
                currentAttendanceStudents.setOverall(rs.getInt("Overall"));
                currentAttendanceStudents.setId(rs.getInt("id"));

                students.add(currentAttendanceStudents);

            }
        } catch (SQLException ex)
        {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    /**
     * gets all teachers from the database
     * @return 
     */
    public List<Teachers> getAllTeachers()
    {
        List<Teachers> teachers = new ArrayList();

        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Teachers");
            while (rs.next())
            {
                Teachers currentAttendanceTeachers = new Teachers();

                currentAttendanceTeachers.setFirstName(rs.getString("FirstName"));
                currentAttendanceTeachers.setLastName(rs.getString("LastName"));
                currentAttendanceTeachers.setCity(rs.getString("City"));
                currentAttendanceTeachers.setCountry(rs.getString("Country"));
                currentAttendanceTeachers.setEmail(rs.getString("Email"));

                teachers.add(currentAttendanceTeachers);

            }
        } catch (SQLException ex)
        {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teachers;
    }
    /**
     * Will log in a user based on what he/she types in as login information
     * program check the database for the info, to see if it is a registert user
     * if it is, then the program wil log in to the correct windows.
     * @param password
     * @param email
     * @param cwc
     * @param root1
     * @param fxmlLoader
     * @param root2
     * @param fxmlLoader2
     * @param loginBtn 
     */
    public void getAllLogins(String password, String email, CorrectWindowController cwc, Parent root1, FXMLLoader fxmlLoader, Parent root2, FXMLLoader fxmlLoader2, JFXButton loginBtn)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Login WHERE Username = ? and Password = ? and IsTeacher = 1";
        try (Connection con = dbc.getConnection())
        {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
            {
                System.out.println("Teacher login failed");
            } else
            {
                System.out.println("Teacher login succes");
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Attendance Window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                Stage stageClose = (Stage) loginBtn.getScene().getWindow();
                stageClose.close();

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        String sqlTeacher = "SELECT * FROM Login WHERE Username = ? and Password = ? and IsTeacher = 0";
        try (Connection conTeach = dbc.getConnection())
        {
            preparedStatement = conTeach.prepareStatement(sqlTeacher);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
            {
                System.out.println("Student login failed");
            } else
            {
                System.out.println("Student login succes");
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));
                stage.setTitle("Attendance Window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                Stage stageClose = (Stage) loginBtn.getScene().getWindow();
                stageClose.close();

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
