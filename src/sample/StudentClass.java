package sample;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentClass {
    private SimpleStringProperty studentClassName;
    private SimpleStringProperty studentClassroom;
    private SimpleStringProperty studentClassDay;
    private SimpleStringProperty studentProfessor;

    public StudentClass(String studentClassName, String studentClassroom,String studentClassDay, String studentProfessor){
        this.studentClassName = new SimpleStringProperty(studentClassName);
        this.studentClassroom = new SimpleStringProperty(studentClassroom);
        this.studentClassDay = new SimpleStringProperty(studentClassDay);
        this.studentProfessor = new SimpleStringProperty(studentProfessor);
    }

    public StudentClass() {
        this.studentClassName = new SimpleStringProperty("NA");
        this.studentClassroom = new SimpleStringProperty("NA");
        this.studentClassDay = new SimpleStringProperty("NA");
        this.studentProfessor = new SimpleStringProperty("NA");
    }

    public static ObservableList loadDummyData() {
        ObservableList<StudentClass> studentClasses = FXCollections.observableArrayList();
        studentClasses.add(new StudentClass("Class1", "Room1", "Monday", "Professor X"));
        studentClasses.add(new StudentClass("Class2", "Room2", "Tuesday", "Professor X"));
        studentClasses.add(new StudentClass("Class3", "Room3", "Wednesday", "Professor X"));
        studentClasses.add(new StudentClass("Class4", "Room4", "Thursday", "Professor X"));
        return studentClasses;
    }

    public String getStudentClassName() { return studentClassName.get(); }
    public SimpleStringProperty studentClassNameProperty() { return studentClassName; }
    public void setStudentClassName(String studentClassName) { this.studentClassName.set(studentClassName); }
    public String getStudentClassroom() { return studentClassroom.get(); }
    public SimpleStringProperty studentClassroomProperty() { return studentClassroom; }
    public void setStudentClassroom(String studentClassroom) { this.studentClassroom.set(studentClassroom); }
    public String getStudentClassDay() { return studentClassDay.get(); }
    public SimpleStringProperty studentClassDayProperty() { return studentClassDay; }
    public void setStudentClassDay(String studentClassDay) { this.studentClassDay.set(studentClassDay); }
    public String getStudentProfessor() { return studentProfessor.get(); }
    public SimpleStringProperty studentProfessorProperty() { return studentProfessor; }
    public void setStudentProfessor(String studentProfessor) { this.studentProfessor.set(studentProfessor); }
}
