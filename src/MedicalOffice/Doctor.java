package MedicalOffice;

import java.util.Comparator;

public class Doctor {

    private int id;
    private int yearsOfExperience;
    private String firstName;
    private String lastName;
    private int age;
    private String telephoneNumber;
    private String priceRange;

    public Doctor(){}
    public Doctor(int id,int yearsOfExperience, String firstName, String lastName, int age, String telephoneNumber, String priceRange) {
        this.id = id;
        this.yearsOfExperience = yearsOfExperience;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.priceRange = priceRange;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }


}
