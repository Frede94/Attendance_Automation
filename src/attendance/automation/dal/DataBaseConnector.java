/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author Jens Karlskov
 */
public class DataBaseConnector
{
    /**
     * Creates a connection to the database user.
     */
    private SQLServerDataSource ds = new SQLServerDataSource();

    public DataBaseConnector()
    {
        ds.setDatabaseName("Attendance_Emma");
        ds.setUser("CS2017A_9_java");
        ds.setPassword("javajava");
        ds.setServerName("EASV-DB2");
        ds.setPortNumber(1433);
    }

    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }
}
