package MedicalOffice;

import java.util.Vector;

public class Pacient extends Person implements Comparable<Pacient>{

    private String symptoms;
    private boolean insurance;
    private boolean covidTest;

    public Pacient(){}

    public Pacient(int id, int age, String firstName, String lastName, String symptoms, boolean insurance,boolean covidTest) {
        super(id, age, firstName, lastName);
        this.symptoms = symptoms;
        this.insurance = insurance;
        this.covidTest = covidTest;
    }

    public boolean isChild(){
        if (getAge() < 18)
            return true;
        return false;
    }

    public boolean hasInsurance(){
        if(this.insurance == false)
            return false;
        return true;
    }

    public boolean hasCovid(){
        if(this.covidTest == true)
            return true;
        return false;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString(){
        String infoPacient =  getFirstName() + " " + getLastName() + ", Varsta " + getAge() + ", Covid-19 " + hasCovid() + ", Simptome: " + getSymptoms();

        return infoPacient;
    }

    @Override
    public int compareTo(Pacient pacient){
        return this.getFirstName().compareTo(pacient.getFirstName());
    }
}
