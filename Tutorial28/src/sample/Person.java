package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Returns the firstName value
    public String getFirstName() {
        return firstName.get();
    }

    //Returns StringProperty object
    public StringProperty firstNameProperty() { // Can add listener to a field
        return firstName;
    }

    //Set the firstName value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
