package MedicalOffice;

public class Psychologist extends Doctor{

    public Psychologist(int yearsOfExperience,String specialty, String firstName, String lastName, int age, String telephoneNumber, String priceRange) {
        super(yearsOfExperience,specialty, firstName, lastName, age, telephoneNumber, priceRange);
    }

    public Psychologist(int id,int yearsOfExperience,String specialty, String firstName, String lastName, int age, String telephoneNumber, String priceRange) {
        super(id,yearsOfExperience,specialty, firstName, lastName, age, telephoneNumber, priceRange);
    }

    @Override
    public String toString(){
        return "Medic Psiholog " + getFirstName() + " " + getLastName() + " Ani de experienta " + getYearsOfExperience()
                + ", nr de telefon " + getTelephoneNumber() + ", interval de pret " + getPriceRange();
    }
}
