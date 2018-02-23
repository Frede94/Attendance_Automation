/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.be.Students;
import attendance.automation.be.Teachers;
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
    StudentsManager studentsManager = new StudentsManager();
    private static ObservableList<Students> tableAttendees = FXCollections.observableArrayList();    
    private static ObservableList<Students> tableCorrectOverview = FXCollections.observableArrayList();    
    private static ObservableList<Teachers> tableTeachersTeachers = FXCollections.observableArrayList();    
    
    
    /**
     * Constructor til Model klassen
     */
    public Model()
    {
        this.tableAttendees = FXCollections.observableArrayList();
        tableAttendees.addAll(studentsManager.getAllStudents());
        
        this.tableTeachersTeachers = FXCollections.observableArrayList();
        tableTeachersTeachers.addAll(studentsManager.getAllTeachers());
        
        this.tableCorrectOverview = FXCollections.observableArrayList();
        tableCorrectOverview.addAll(studentsManager.getAllStudents());

        loadStudents();
        
        
    }

    /**
     * Rydder listen og loader students fra databasen. "getAllStudents"
     */
     void loadStudents()
    {
        List<Students> loadedStudents = studentsManager.getAllStudents();

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

    void loadTeachers()
    {
        List<Teachers> loadedTeachers = studentsManager.getAllTeachers();

        tableTeachersTeachers.clear();
        tableTeachersTeachers.addAll(loadedTeachers);
    }

    public ObservableList<Teachers> getTeachers()
    {
        return tableTeachersTeachers;
    }

    ObservableList<Students> getStudentsCorrect()
    {
        return tableCorrectOverview;
    }
}
