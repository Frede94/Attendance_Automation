/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.be;

/**
 *
 * @author Jens Karlskov
 */
public class Students
{
    
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String email;
    private int DBOS;
    private int SCO;
    private int SDE;
    private int ITO;
    private int overall;
    private int id;

    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    

    /**
     * Get the value of overall
     *
     * @return the value of overall
     */
    public int getOverall()
    {
        return overall;
    }

    /**
     * Set the value of overall
     *
     * @param overall new value of overall
     */
    public void setOverall(int overall)
    {
        this.overall = overall;
    }


    /**
     * Get the value of ITO
     *
     * @return the value of ITO
     */
    public int getITO()
    {
        return ITO;
    }

    /**
     * Set the value of ITO
     *
     * @param ITO new value of ITO
     */
    public void setITO(int ITO)
    {
        this.ITO = ITO;
    }


    /**
     * Get the value of SDE
     *
     * @return the value of SDE
     */
    public int getSDE()
    {
        return SDE;
    }

    /**
     * Set the value of SDE
     *
     * @param SDE new value of SDE
     */
    public void setSDE(int SDE)
    {
        this.SDE = SDE;
    }


    /**
     * Get the value of SCO
     *
     * @return the value of SCO
     */
    public int getSCO()
    {
        return SCO;
    }

    /**
     * Set the value of SCO
     *
     * @param SCO new value of SCO
     */
    public void setSCO(int SCO)
    {
        this.SCO = SCO;
    }


    /**
     * Get the value of DBOS
     *
     * @return the value of DBOS
     */
    public int getDBOS()
    {
        return DBOS;
    }

    /**
     * Set the value of DBOS
     *
     * @param DBOS new value of DBOS
     */
    public void setDBOS(int DBOS)
    {
        this.DBOS = DBOS;
    }


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
@Override
    public String toString()
    {
        return "Studets{" + "FirstName=" + firstName + ", LastName=" + lastName + ", City=" + city + ", Country=" + country + ", Email" + email + ", DBOS" + DBOS + ", SCO" + SCO + ", SDE" + SDE + ", ITO" + ITO + ", Overall" + overall + ", Id" + id +'}';
    }
    
}
