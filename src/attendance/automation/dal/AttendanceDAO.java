/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.dal;

import attendance.automation.be.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
     * Will log in a user based on what he/she types in as login information
     * program check the database for the info, to see if it is a registert user
     * if it is, then the program wil log in to the correct windows.
     *
     * @param password
     * @param username
     * @return
     * @throws java.lang.Exception
     */
    public Person Login(String password, String username) throws Exception
    {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Login WHERE Username = ? and Password = ?";
        try (Connection con = dbc.getConnection())
        {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
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
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Person WHERE Id =" + personId);
            rs.next();
            Person currentPerson = new Person();
            currentPerson.setId(rs.getInt("Id"));
            currentPerson.setLname(rs.getString("Lname"));
            currentPerson.setFname(rs.getString("Fname"));
            currentPerson.setEmail(rs.getString("Email"));
            currentPerson.setAddress(rs.getString("Address"));
            currentPerson.setZipCode(rs.getInt("ZipCode"));

            return currentPerson;
        } catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return null;
    }

    /**
     * Knapperne skal flyttes til Controlleren, de er kun her midlertidigt gets
     * the current date from the system, and inserts it into the database
     *
     * @param absent
     * @param present
     */
    public void addAttendance(boolean present)
    {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        if (present)
        {
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
        } else if (!present)
        {

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
//            PreparedStatement statement = null;
//            ResultSet resultSet = null;
//            
//            String sql = "INSERT INTO Attendance (Date, PersonId, IsPresent) VALUES(?, ?, ?)";
//            java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
//            statement.setTimestamp(1, timestamp);
//            statement.setInteger(2, p.getId());
//            statement.setBoolean(3, present);
//            
//            statement.execute();
