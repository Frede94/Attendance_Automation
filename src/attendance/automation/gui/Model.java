/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.bll.StudentsManager;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 *
 * @author Jens Karlskov
 */
public class Model
{

    StudentsManager studentsManager = new StudentsManager();
    private static ObservableList<?> tableAttendees = FXCollections.observableArrayList();
    private static ObservableList<?> tableCorrectOverview = FXCollections.observableArrayList();
    private static ObservableList<?> tableTeachersTeachers = FXCollections.observableArrayList();

    /**
     * Constructor til Model klassen
     */
    public Model()
    {

// !!TO DELETE !! TO DELETE!!
//        this.tableAttendees = FXCollections.observableArrayList();
//        tableAttendees.addAll(studentsManager.getAllStudents());
//        
//        this.tableTeachersTeachers = FXCollections.observableArrayList();
//        tableTeachersTeachers.addAll(studentsManager.getAllTeachers());
//        
//        this.tableCorrectOverview = FXCollections.observableArrayList();
//        tableCorrectOverview.addAll(studentsManager.getAllStudents());
//        loadStudents();
    }
}
