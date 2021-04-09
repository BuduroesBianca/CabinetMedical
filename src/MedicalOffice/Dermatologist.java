package MedicalOffice;

public class Dermatologist extends Doctor{

    public Dermatologist(int id,int yearsOfExperience, String firstName, String lastName, int age, String telephoneNumber, String priceRange) {
        super(id,yearsOfExperience, firstName, lastName, age, telephoneNumber, priceRange);
    }

    @Override
    public String toString(){
        return "Medic Dermatolog " + getFirstName() + " " + getLastName() + " Ani de experienta " + getYearsOfExperience()
                + ", nr de telefon " + getTelephoneNumber() + ", interval de pret " + getPriceRange();
    }
}
