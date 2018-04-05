/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.be;

/**
 *
 * @author Mikkel
 */
public class Person
{

    private int Id;
    private String Lname;
    private String Fname;
    private String Email;
    private String Address;
    private int ZipCode;
    private boolean isTeacher;

    /**
     * Get the value of isTeacher
     *
     * @return the value of isTeacher
     */
    public boolean isIsTeacher()
    {
        return isTeacher;
    }

    /**
     * Set the value of isTeacher
     *
     * @param isTeacher new value of isTeacher
     */
    public void setIsTeacher(boolean isTeacher)
    {
        this.isTeacher = isTeacher;
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public String getLname()
    {
        return Lname;
    }

    public void setLname(String Lname)
    {
        this.Lname = Lname;
    }

    public String getFname()
    {
        return Fname;
    }

    public void setFname(String Fname)
    {
        this.Fname = Fname;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    public String getAddress()
    {
        return Address;
    }

    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    public int getZipCode()
    {
        return ZipCode;
    }

    public void setZipCode(int ZipCode)
    {
        this.ZipCode = ZipCode;
    }

}
