/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.dal;

import attendance.automation.be.Students;
import attendance.automation.be.Teachers;
import attendance.automation.gui.CorrectWindowController;
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
import javafx.scene.Node;
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

    public void getAllLogins2(String password, String email)
    {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Login WHERE Username = ? and Password = ?";
        try (Connection con = dbc.getConnection())
        {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
            {
                System.out.println("failed");
            } else
            {
                System.out.println("login succes");

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void getAllLogins(String password, String email, CorrectWindowController cwc, Parent root1, FXMLLoader fxmlLoader)
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Login WHERE Username = ? and Password = ?";
        try (Connection con = dbc.getConnection())
        {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
            {
                System.out.println("failed");
            } else
            {
                System.out.println("login succes");
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Attendance Window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();

            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
