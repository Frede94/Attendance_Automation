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
public class Teachers
{
    
    private String firstName;
    
    private String lastName;
    
    private String city;
    
    private String country;
    
    private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }


    /**
     * Get the value of country
     *
     * @return the value of country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * Set the value of country
     *
     * @param country new value of country
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * Get the value of city
     *
     * @return the value of city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Set the value of city
     *
     * @param city new value of city
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

}
