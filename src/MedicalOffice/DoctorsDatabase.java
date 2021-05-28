package MedicalOffice;

import javax.xml.crypto.Data;
import java.util.*;
import java.sql.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorsDatabase {

    private static Connection connection;
    private static DoctorsDatabase instance;

    private DoctorsDatabase() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:derby:C:/Users/Bianca/source/repos/MedicalOffice/MedicalOfficeDB;create=true");
        boolean notFoundDoctors = true;


        ResultSet results = connection.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
        while(results.next()){
            if("doctors".equalsIgnoreCase(results.getString("TABLE_NAME"))){
                notFoundDoctors = false;
                break;
            }
        }

        if(notFoundDoctors){
            connection.createStatement().execute("CREATE TABLE doctors (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), YEARSOFEXPERIENCE int,SPECIALTY varchar(50),FIRSTNAME varchar(50),LASTNAME varchar(50),AGE int,TELEPHONENUMBER varchar(10),PRICERANGE varchar(5))");
        }
    }

    public static DoctorsDatabase getDatabaseInstance() {
        if (instance == null)
            try {
                instance = new DoctorsDatabase();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        return instance;
    }

    public void dropTable(){

        try {
            PreparedStatement stmt = connection.prepareStatement("DROP TABLE doctors");
            stmt.executeUpdate();
            System.out.println("Table doctors dropped!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addDoctor(Doctor doctor) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO doctors(YEARSOFEXPERIENCE,SPECIALTY,FIRSTNAME,LASTNAME,AGE,TELEPHONENUMBER,PRICERANGE) VALUES (?,?,?,?,?,?,?)");

            //statement.setInt(1, doctor.getId());
            statement.setInt(1,doctor.getYearsOfExperience());
            statement.setString(2,doctor.getSpecialty());
            statement.setString(3, doctor.getFirstName());
            statement.setString(4, doctor.getLastName());
            statement.setInt(5,doctor.getAge());
            statement.setString(6, doctor.getTelephoneNumber());
            statement.setString(7, doctor.getPriceRange());

            statement.executeUpdate();
            System.out.println("Doctorul a fost adaugat cu succes.");
        }catch (SQLException e){
            System.out.println("Doctorul nu a fost adaugat. Eroare.");
            e.printStackTrace();
        }
    }

    public void showDoctors(){
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM doctors");
            while (resultSet.next())
            {
                System.out.println("Id:" + resultSet.getInt(1));
                System.out.println("Ani de experienta:" + resultSet.getInt(2));
                System.out.println("Specializare: " + resultSet.getString(3));
                System.out.println("Nume:" + resultSet.getString(4));
                System.out.println("Prenume:" + resultSet.getString(5));
                System.out.println("Varsta:" + resultSet.getInt(6));
                System.out.println("Numar de telefon:" + resultSet.getString(7));
                System.out.println("Intervalul de pret:" + resultSet.getString(8));
                System.out.println("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Doctor> Read() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            ResultSet results = connection.createStatement().executeQuery("SELECT ID,YEARSOFEXPERIENCE,SPECIALTY,FIRSTNAME,LASTNAME,AGE,TELEPHONENUMBER,PRICERANGE FROM doctors");
            while (results.next()) {
                System.out.println(results.getString(3));
                switch(results.getString(3)){
                    case "Cardiologist" : {
                        doctors.add(new Cardiologist(results.getInt(1),results.getInt(2),results.getString(3), results.getString(4), results.getString(5), results.getInt(6), results.getString(7), results.getString(8)));
                        break;
                    }
                    case "Dentist" : {
                        doctors.add(new Dentist(results.getInt(1),results.getInt(2),results.getString(3), results.getString(4), results.getString(5), results.getInt(6), results.getString(7), results.getString(8)));
                        break;
                    }
                    case "Dermatologist" : {
                        doctors.add(new Dermatologist(results.getInt(1),results.getInt(2),results.getString(3), results.getString(4), results.getString(5), results.getInt(6), results.getString(7), results.getString(8)));
                        break;
                    }
                    case "Psychologist" : {
                        doctors.add(new Psychologist(results.getInt(1),results.getInt(2),results.getString(3), results.getString(4), results.getString(5), results.getInt(6), results.getString(7), results.getString(8)));
                        break;
                    }
                }

            }
            return doctors;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }



    public static void updateDoctor(String firstName,String lastName,String fieldToUpdate, String updatedValue){
        PreparedStatement statement;
        switch (fieldToUpdate){
            case "AGE" : {
                try {
                    statement = connection.prepareStatement("UPDATE doctors SET AGE = ? WHERE lastName = ? and firstName = ?");
                    statement.setInt(1, Integer.parseInt(updatedValue));
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Varsta a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Varsta nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "FIRSTNAME" : {
                try {
                    statement = connection.prepareStatement("UPDATE doctors SET FIRSTNAME = ? WHERE lastName = ? and firstName = ?");
                    statement.setString(1, updatedValue);
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Prenume a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Prenume nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "LASTNAME" : {
                try {
                    statement = connection.prepareStatement("UPDATE doctors SET LASTNAME = ? WHERE lastName = ? and firstName = ?");
                    statement.setString(1, updatedValue);
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Nume a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Nume nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "YEARSOFEXPERIENCE" : {
                try {
                    statement = connection.prepareStatement("UPDATE doctors SET YEARSOFEXPERIENCE = ? WHERE lastName = ? and firstName = ?");
                    statement.setInt(1, Integer.parseInt(updatedValue));
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Ani de Experienta a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Ani de Experienta nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "TELEPHONENUMBER" : {
                try {
                    statement = connection.prepareStatement("UPDATE doctors SET TELEPHONENUMBER = ? WHERE lastName = ? and firstName = ?");
                    statement.setString(1, updatedValue);
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Nr. de Telefon a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Nr. de Telefon nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "PRICERANGE" : {
                try {
                    statement = connection.prepareStatement("UPDATE doctors SET PRICERANGE = ? WHERE lastName = ? and firstName = ?");
                    statement.setString(1, updatedValue);
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Interval de pret a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Interval de pret nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            default:
                System.out.println("Nu exista aceasta coloana in tabela doctori.");
        }
    }

    public void deleteDoctor(int id){
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM doctors WHERE id = ?");
            stmt.setInt(1,id);


            stmt.executeUpdate();
            System.out.println("Doctorul a fost sters cu succes.");
        }catch (SQLException e){
            System.out.println("Doctorul nu a fost sters. Eroare.");
            e.printStackTrace();
        }
    }

    protected static void writeDataToCsv(String csvFile, String[] data){
        try {
            File file = new File ("data/"+csvFile);
            if (!file.exists())
                file.createNewFile();

            FileWriter csvWriter = new FileWriter(file, true);
            csvWriter.write(String.join(",", data));
            csvWriter.write("\n");
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
