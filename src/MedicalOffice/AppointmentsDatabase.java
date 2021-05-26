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

public class AppointmentsDatabase {

    private static Connection connection;
    private static AppointmentsDatabase instance;

    private AppointmentsDatabase() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:derby:C:/Users/Bianca/source/repos/MedicalOffice/MedicalOfficeDB;create=true");
        boolean notFoundAppointments = true;


        ResultSet results = connection.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
        while(results.next()){
            if("appointments".equalsIgnoreCase(results.getString("TABLE_NAME"))){
                notFoundAppointments = false;
                break;
            }
        }

        if(notFoundAppointments){
            connection.createStatement().execute("CREATE TABLE appointments (ID int not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), IDPACIENT int,IDDOCTOR int,MOTIVE varchar(100),ORA int,DATE varchar(15))");
        }

    }


    public static AppointmentsDatabase getDatabaseInstance1() {
        if (instance == null)
            try {
                instance = new AppointmentsDatabase();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        return instance;
    }

    public void dropTable(){

        try {
            PreparedStatement stmt = connection.prepareStatement("DROP TABLE appointments");
            stmt.executeUpdate();
            System.out.println("Table appointments dropped!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addAppointment(int idPacient,int idDoctor,String motive,int hour,String date) {
        Appointment appointment = new Appointment(idPacient,idDoctor,motive,hour,date);

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO appointments (idPacient,idDoctor,motive,ora,date) VALUES (?,?,?,?,?)");

            statement.setInt(1,appointment.getIdPacient());
            statement.setInt(2,appointment.getIdDoctor());
            statement.setString(3, appointment.getMotive());
            statement.setInt(4,appointment.getHour());
            statement.setString(5, appointment.getDate());

            statement.executeUpdate();
            System.out.println("Programarea a fost adaugata cu succes");
        }catch (SQLException e){
            System.out.println("Programarea nu a fost adaugata. Eroare.");
            e.printStackTrace();
        }
    }

    public void showAppointments(){
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM appointments");
            while (resultSet.next())
            {
                System.out.println("Id:" + resultSet.getInt(1));
                System.out.println("Id Pacient:" + resultSet.getInt(2));
                System.out.println("Id Doctor:" + resultSet.getInt(3));
                System.out.println("Motivele programarii:" + resultSet.getString(4));
                System.out.println("Ora:" + resultSet.getInt(5));
                System.out.println("Data:" + resultSet.getString(6));

                System.out.println("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Appointment> Read() {
        List<Appointment> appointments = new ArrayList<>();
        try {
            ResultSet results = connection.createStatement().executeQuery("SELECT IDPACIENT,IDDOCTOR,MOTIVE,ORA,DATE FROM appointments");
            while (results.next()) {
                appointments.add(new Appointment(results.getInt(1), results.getInt(2), results.getString(3), results.getInt(4), results.getString(5)));
            }
            return appointments;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void updateAppointment(int idPacient,int idDoctor, String fieldToUpdate,String updatedValue){
        PreparedStatement statement;
        switch (fieldToUpdate){
            case "IDPACIENT" : {
                try {
                    statement = connection.prepareStatement("UPDATE appointments SET IDPACIENT = ? WHERE idPacient = ? and idDoctor = ?");
                    statement.setInt(1, Integer.parseInt(updatedValue));
                    statement.setInt(2, idPacient);
                    statement.setInt(3,idDoctor);
                    statement.executeUpdate();
                    System.out.println("Campul IdPacient a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul IdPacient nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "IDDOCTOR" : {
                try {
                    statement = connection.prepareStatement("UPDATE appointments SET IDDOCTOR = ? WHERE idPacient = ? and idDoctor = ?");
                    statement.setInt(1, Integer.parseInt(updatedValue));
                    statement.setInt(2, idPacient);
                    statement.setInt(3,idDoctor);
                    statement.executeUpdate();
                    System.out.println("Campul IdDoctor a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul IdDoctor nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "MOTIVE" : {
                try {
                    statement = connection.prepareStatement("UPDATE appointments SET MOTIVE = ? WHERE idPacient = ? and idDoctor = ?");
                    statement.setString(1, updatedValue);
                    statement.setInt(2, idPacient);
                    statement.setInt(3,idDoctor);
                    statement.executeUpdate();
                    System.out.println("Campul Motiv a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Motiv nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            case "HOUR" : {
                try {
                    statement = connection.prepareStatement("UPDATE appointments SET ORA = ? WHERE idPacient = ? and idDoctor = ?");
                    statement.setInt(1, Integer.parseInt(updatedValue));
                    statement.setInt(2, idPacient);
                    statement.setInt(3,idDoctor);
                    statement.executeUpdate();
                    System.out.println("Campul Ora a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Ora nu a fost modificat. Eroare");
                    e.printStackTrace();
                }
            }
            case "DATE" : {
                try {
                    statement = connection.prepareStatement("UPDATE appointments SET DATE = ? WHERE idPacient = ? and idDoctor = ?");
                    statement.setString(1, updatedValue);
                    statement.setInt(2, idPacient);
                    statement.setInt(3,idDoctor);
                    statement.executeUpdate();
                    System.out.println("Campul Data a fost modificat cu succes.");
                    break;
                } catch (SQLException e) {
                    System.out.println("Campul Data nu a fost modificat. Eroare.");
                    e.printStackTrace();
                }
            }
            default:
                System.out.println("Nu exista aceasta coloana in tabela appoitnments.");
        }
    }

    public void deleteAppointment(int idPacient,int idDoctor,int ora,String data){
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM appointments WHERE idPacient = ? and idDoctor = ? and ora = ? and date = ?");
            stmt.setInt(1,idPacient);
            stmt.setInt(2,idDoctor);
            stmt.setInt(3,ora);
            stmt.setString(4,data);

            stmt.executeUpdate();
            System.out.println("Programarea a fost anulata.");

        }catch (SQLException e){
            System.out.println("Programarea nu a fost anulata. Eroare.");
            e.printStackTrace();
        }
    }

}
