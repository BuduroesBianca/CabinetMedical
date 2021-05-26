package MedicalOffice;
import java.util.UUID;
public class Person {

   // protected int id;
    private int age;
    private String firstName;
    private String lastName;

    public Person() {}
   // public Person id(int id){
    //    this.id = id;
   //     return this;
   // }

    public Person age(int age) {
        this.age = age;
        return this;
    }


    public Person firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public Person(int age, String firstName, String lastName){
        //this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //public int getId() {
        //return id;
    //}

    //public void setId(int id) {
        //this.id = id;
    //}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString(){
        /*return id + ", " + */ return age + ", " + firstName + ", " + lastName;
    }
}
