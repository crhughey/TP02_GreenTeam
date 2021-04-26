package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PfStClass {
    private SimpleStringProperty pfStClassFirstName;
    private SimpleStringProperty pfStClassLastName;
    private SimpleStringProperty pfStClassEMail;

    public PfStClass(String pfStClassFirstName, String pfStClassLastName, String pfStClassEMail) {
        this.pfStClassFirstName = new SimpleStringProperty(pfStClassFirstName);
        this.pfStClassLastName = new SimpleStringProperty(pfStClassLastName);
        this.pfStClassEMail = new SimpleStringProperty(pfStClassEMail);
    }

    public PfStClass() {
        this.pfStClassFirstName = new SimpleStringProperty("NA");
        this.pfStClassLastName = new SimpleStringProperty("NA");
        this.pfStClassEMail = new SimpleStringProperty("NA");
    }

    public static ObservableList loadDummyData() {
        ObservableList<PfStClass> pfStClassFirstName = FXCollections.observableArrayList();
        pfStClassFirstName.add(new PfStClass("FirstName1", "LastName1", "Email1@gmail.com"));
        pfStClassFirstName.add(new PfStClass("FirstName2", "LastName2", "Email2@gmail.com"));
        pfStClassFirstName.add(new PfStClass("FirstName3", "LastName3", "Email3@gmail.com"));
        pfStClassFirstName.add(new PfStClass("FirstName4", "LastName4", "Email4@gmail.com"));
        return pfStClassFirstName;
    }

    public String getPfStClassFirstName() {
        return pfStClassFirstName.get();
    }
    public void setPfStClassFirstName(String pfStClassFirstName) {
        this.pfStClassFirstName.set(pfStClassFirstName);
    }
    public String getPfStClassLastName() {
        return pfStClassLastName.get();
    }
    public void setPfStClassLastName(String pfStClassLastName) {
        this.pfStClassLastName.set(pfStClassLastName);
    }
    public String getPfStClassEMail() {
        return pfStClassEMail.get();
    }
    public void setPfStClassEMail(String pfStClassEMail) {
        this.pfStClassEMail.set(pfStClassEMail);
    }
}
