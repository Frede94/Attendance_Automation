/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.be.Students;
import attendance.automation.bll.StudentsManager;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 *
 * @author Jens Karlskov
 */
public class Model
{
    StudentsManager StudentsManager = new StudentsManager();
    private static ObservableList<Students> tableAttendees = FXCollections.observableArrayList();    
    
    
    /**
     * Constructor til Model klassen
     */
    public Model()
    {
        this.tableAttendees = FXCollections.observableArrayList();
        tableAttendees.addAll(StudentsManager.getAllStudents());

        loadStudents();
    }

    /**
     * Rydder listen og loader students fra databasen. "getAllStudents"
     */
     void loadStudents()
    {
        List<Students> loadedStudents = StudentsManager.getAllStudents();

        tableAttendees.clear();
        tableAttendees.addAll(loadedStudents);
    }
     /**
     * Retunerer Students
     *
     * @return
     */
    public ObservableList<Students> getStudents()
    {
        return tableAttendees;
    }
}
