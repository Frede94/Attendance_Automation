/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.dal;

import attendance.automation.be.Students;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}
