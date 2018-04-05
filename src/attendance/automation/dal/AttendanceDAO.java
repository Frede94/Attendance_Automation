/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.dal;

import attendance.automation.be.Person;
import attendance.automation.be.Students;
import attendance.automation.be.Teachers;
import attendance.automation.be.User;
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

/**
 *
 * @author Jens Karlskov
 */
public class AttendanceDAO
{

    DataBaseConnector dbc = new DataBaseConnector();

    /**
     * get all student from the database
     *
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
     *
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
     *
     */
    public Person Login(String password, String username) throws Exception
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Login WHERE Username = ? and Password = ? and IsTeacher = 1";
        try (Connection con = dbc.getConnection())
        {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
            {
                boolean teacher = resultSet.getBoolean("IsTeacher");
                int personId = resultSet.getInt("PersonId");

                Person p = getPerson(personId, con);
                p.setIsTeacher(teacher);
                return p;

            } else
            {
                throw new Exception("Login failed");

            }

        } 

    }

    private Person getPerson(int personId, Connection con)
    {
        return null;
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

