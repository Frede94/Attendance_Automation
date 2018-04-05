/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.be;

/**
 *
 * @author Frederik Bærbar
 */
public class User
{
    
    private int PersonId;
    
    private String Username;
    
    private String Password;
    
    private String IsTeacher;

    /**
     * Get the value of IsTeacher
     *
     * @return the value of IsTeacher
     */
    public String getIsTeacher()
    {
        return IsTeacher;
    }

    /**
     * Set the value of IsTeacher
     *
     * @param IsTeacher new value of IsTeacher
     */
    public void setIsTeacher(String IsTeacher)
    {
        this.IsTeacher = IsTeacher;
    }

    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword()
    {
        return Password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    /**
     * Get the value of Username
     *
     * @return the value of Username
     */
    public String getUsername()
    {
        return Username;
    }

    /**
     * Set the value of Username
     *
     * @param Username new value of Username
     */
    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    /**
     * Get the value of PersonId
     *
     * @return the value of PersonId
     */
    public int getPersonId()
    {
        return PersonId;
    }

    /**
     * Set the value of PersonId
     *
     * @param PersonId new value of PersonId
     */
    public void setPersonId(int PersonId)
    {
        this.PersonId = PersonId;
    }

}
