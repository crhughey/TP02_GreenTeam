package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PfClass {
    private SimpleStringProperty pfClassName;
    private SimpleStringProperty pfClassRoom;
    private SimpleStringProperty pfClassDay;

    public PfClass(String pfClassName, String pfClassRoom, String pfClassDay) {
        this.pfClassName = new SimpleStringProperty(pfClassName);
        this.pfClassRoom = new SimpleStringProperty(pfClassRoom);
        this.pfClassDay = new SimpleStringProperty(pfClassDay);
    }

    public PfClass() {
        this.pfClassName = new SimpleStringProperty("NA");
        this.pfClassRoom = new SimpleStringProperty("NA");
        this.pfClassDay = new SimpleStringProperty("NA");
    }

    public static ObservableList loadDummyData() {
        ObservableList<PfClass> pfClasses = FXCollections.observableArrayList();
        pfClasses.add(new PfClass("Class1", "Room1", "Monday1"));
        pfClasses.add(new PfClass("Class2", "Room2", "Monday2"));
        pfClasses.add(new PfClass("Class3", "Room3", "Monday3"));
        pfClasses.add(new PfClass("Class4", "Room4", "Monday4"));
        return pfClasses;
    }

    public String getPfClassName() {
        return pfClassName.get();
    }
    public void setPfClassName(String pfClassName) {
        this.pfClassName.set(pfClassName);
    }
    public String getPfClassRoom() {
        return pfClassRoom.get();
    }
    public void setPfClassRoom(String pfClassRoom) {
        this.pfClassRoom.set(pfClassRoom);
    }
    public String getPfClassDay() {
        return pfClassDay.get();
    }
    public void setPfClassDay(String pfClassDay) {
        this.pfClassDay.set(pfClassDay);
    }
}

