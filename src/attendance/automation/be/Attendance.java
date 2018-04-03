/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.be;

import java.util.Date;

/**
 *
 * @author Frederik Bærbar
 */
public class Attendance
{
    
    private int attID;
    private int studentID; 
    private Date date;   
    private boolean isPresent;
    
    public Date getDate()
    {
        return date;      
    }
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    

    /**
     * Get the value of isPresent
     *
     * @return the value of isPresent
     */
    public boolean isIsPresent()
    {
        return isPresent;
    }

    /**
     * Set the value of isPresent
     *
     * @param isPresent new value of isPresent
     */
    public void setIsPresent(boolean isPresent)
    {
        this.isPresent = isPresent;
    }

    /**
     * Get the value of studentID
     *
     * @return the value of studentID
     */
    public int getStudentID()
    {
        return studentID;
    }

    /**
     * Set the value of studentID
     *
     * @param studentID new value of studentID
     */
    public void setStudentID(int studentID)
    {
        this.studentID = studentID;
    }


    /**
     * Get the value of attID
     *
     * @return the value of attID
     */
    public int getAttID()
    {
        return attID;
    }

    /**
     * Set the value of attID
     *
     * @param attID new value of attID
     */
    public void setAttID(int attID)
    {
        this.attID = attID;
    }

}
