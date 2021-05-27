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

public class PacientsDatabase {

    private static Connection connection;
    private static PacientsDatabase instance;

    private PacientsDatabase() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:derby:C:/Users/Bianca/source/repos/MedicalOffice/MedicalOfficeDB;create=true");
        boolean notFoundPacients = true;
        boolean notFoundDoctors = true;
        boolean notFoundAppointments = true;

        ResultSet results = connection.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
        while(results.next()){
            if("pacients".equalsIgnoreCase(results.getString("TABLE_NAME"))){
                notFoundPacients = false;
                break;
            }
        }

        if(notFoundPacients){
            connection.createStatement().execute("CREATE TABLE pacients (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), AGE int,FIRSTNAME varchar(50),LASTNAME varchar(50),SYMPTOMS varchar(100),INSURANCE boolean,COVIDTEST boolean)");
        }

    }


    public static PacientsDatabase getDatabaseInstance() {
        if (instance == null)
            try {
                instance = new PacientsDatabase();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        return instance;
    }

    public void dropTable(){

        try {
            PreparedStatement stmt = connection.prepareStatement("DROP TABLE pacients");
            stmt.executeUpdate();
            System.out.println("table dropped");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void addPacient(int age,String firstName,String lastName, String symptoms, boolean insurance, boolean covidTest ) {
        Pacient pacient = new Pacient(age,firstName,lastName,symptoms,insurance,covidTest);

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO pacients (AGE,FIRSTNAME,LASTNAME,SYMPTOMS,INSURANCE,COVIDTEST) VALUES (?,?,?,?,?,?)");

            //statement.setInt(1, pacient.getId());
            statement.setInt(1, pacient.getAge());
            statement.setString(2, pacient.getFirstName());
            statement.setString(3, pacient.getLastName());
            statement.setString(4, pacient.getSymptoms());
            statement.setBoolean(5, pacient.isInsurance());
            statement.setBoolean(6, pacient.isCovidTest());

            statement.executeUpdate();
            System.out.println("Pacientul a fost adaugat cu succes.");
        }catch (SQLException e){
            System.out.println("Pacientul nu a fost adaugat. Eroare.");
            e.printStackTrace();
        }
    }

    public void showPacients(){
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM pacients");
            while (resultSet.next())
            {
                System.out.println("Id:" + resultSet.getInt(1));
                System.out.println("Varsta:" + resultSet.getInt(2));
                System.out.println("Nume:" + resultSet.getString(3));
                System.out.println("Prenume:" + resultSet.getString(4));
                System.out.println("Simptome:" + resultSet.getString(5));
                System.out.println("Asigurare medicala:" + resultSet.getBoolean(6));
                System.out.println("Test covid:" + resultSet.getBoolean(7));
                System.out.println("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Pacient> Read() {
        List<Pacient> pacients = new ArrayList<>();
        try {
            ResultSet results = connection.createStatement().executeQuery("SELECT ID,AGE,FIRSTNAME,LASTNAME,SYMPTOMS,INSURANCE,COVIDTEST FROM pacients");
            while (results.next()) {
                pacients.add(new Pacient(results.getInt(1),results.getInt(2), results.getString(3), results.getString(4), results.getString(5), results.getBoolean(6), results.getBoolean(7)));
            }
            return pacients;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void updatePacient(String firstName,String lastName,String fieldToUpdate, String updatedValue){
        PreparedStatement statement;
        switch (fieldToUpdate){
            case "AGE" : {
                try {
                    statement = connection.prepareStatement("UPDATE pacients SET AGE = ? WHERE lastName = ? and firstName = ?");
                    statement.setInt(1,  Integer.parseInt(updatedValue));
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
                    statement = connection.prepareStatement("UPDATE pacients SET FIRSTNAME = ? WHERE lastName = ? and firstName = ?");
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
                    statement = connection.prepareStatement("UPDATE pacients SET LASTNAME = ? WHERE lastName = ? and firstName = ?");
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
            case "SYMPTOMS" : {
                try {
                    statement = connection.prepareStatement("UPDATE pacients SET SYMPTOMS = ? WHERE lastName = ? and firstName = ?");
                    statement.setString(1, updatedValue);
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Simptome a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Simptome nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "INSURANCE" : {
                try {
                    statement = connection.prepareStatement("UPDATE pacients SET INSURANCE = ? WHERE lastName = ? and firstName = ?");
                    statement.setBoolean(1, Boolean.parseBoolean(updatedValue));
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul Aigurare Medicala a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Aigurare Medicala nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "COVIDTEST" : {
                try {
                    statement = connection.prepareStatement("UPDATE pacients SET COVIDTEST = ? WHERE lastName = ? and firstName = ?");
                    statement.setBoolean(1, Boolean.parseBoolean(updatedValue));
                    statement.setString(2, firstName);
                    statement.setString(3,lastName);
                    statement.executeUpdate();
                    System.out.println("Campul CovidTest a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul CovidTest nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            default:
                System.out.println("Nu exista aceasta coloana in tabela pacienti.");
        }
    }


    public void deletePacient(int id){
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM pacients WHERE id = ?");
            stmt.setInt(1,id);


            stmt.executeUpdate();
            System.out.println("Pacientul a fost sters cu succes.");

        }catch (SQLException e){
            System.out.println("Pacientul nu a fost sters. Eroare.");
            e.printStackTrace();
        }
    }

}
