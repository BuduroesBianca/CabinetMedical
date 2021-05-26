package MedicalOffice;

public class Dentist extends Doctor{
    public Dentist(int yearsOfExperience, String specialty,String firstName, String lastName, int age, String telephoneNumber, String priceRange) {
        super(yearsOfExperience, specialty,firstName, lastName, age, telephoneNumber, priceRange);
    }

    @Override
    public String toString(){
        return "Medic Dentist " + getFirstName() + " " + getLastName() + " Ani de experienta " + getYearsOfExperience()
                + ", nr de telefon " + getTelephoneNumber() + ", interval de pret " + getPriceRange();
    }
}
