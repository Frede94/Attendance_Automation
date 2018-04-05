/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.dal;

import attendance.automation.gui.CorrectWindowController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
     * Will log in a user based on what he/she types in as login information
     * program check the database for the info, to see if it is a registert user
     * if it is, then the program wil log in to the correct windows.
     *
     * @param password
     * @param email
     * @param cwc
     * @param root1
     * @param fxmlLoader
     * @param root2
     * @param fxmlLoader2
     * @param loginBtn
     */
    public void getAllLogins(String password, String email, CorrectWindowController cwc, Parent root1, FXMLLoader fxmlLoader, Parent root2, FXMLLoader fxmlLoader2, JFXButton loginBtn, Label lblErrorLoginS, Label lblErrorLoginT)
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
                lblErrorLoginT.setText("Teacher login not correct!");
                System.out.println("Teacher login failed");
            } else
            {
                lblErrorLoginS.setText("");
                lblErrorLoginT.setText("");
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
                lblErrorLoginS.setText("Student login not correct!");
                System.out.println("Student login failed");
            } else
            {
                lblErrorLoginS.setText("");
                lblErrorLoginT.setText("");
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

    public void addAttendance(JFXDatePicker dateStud, JFXRadioButton radioButtonPresent, JFXRadioButton radioButtonAbsent)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        if (!radioButtonPresent.isSelected())
        {
            System.out.println("Present");
            try (Connection con = dbc.getConnection())
            {
                PreparedStatement statement = con.prepareStatement("INSERT INTO Attendance (Date, IsPresent) VALUES(?, 1)");
                java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
                statement.setTimestamp(1, timestamp);
                int insertedRecordsCount = statement.executeUpdate();
            } catch (SQLException ex)
            {
                System.out.println(ex);
            }
        } else if (!radioButtonAbsent.isSelected())
        {
            System.out.println("Absent");
            try (Connection con = dbc.getConnection())
            {
                PreparedStatement statement = con.prepareStatement("INSERT INTO Attendance (Date, IsPresent) VALUES(?, 0)");
                java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
                statement.setTimestamp(1, timestamp);
                int insertedRecordsCount = statement.executeUpdate();
            } catch (SQLException ex)
            {
                System.out.println(ex);
            }
        }

    }
}

//            PreparedStatement stmt = con.prepareStatement("INSERT INTO Attendance Date VALUES (GETDATE())");
//
//            stmt.executeUpdate();
//            Statement statement = con.createStatement();
//            
//            String queryAttendance = "Insert into Attendance Set Date = GETDATE ( )";
//            
//            PreparedStatement st = con.prepareStatement(queryAttendance);
//            
//            st.execute();
//__________________________________________________

