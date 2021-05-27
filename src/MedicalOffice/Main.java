package MedicalOffice;

import java.sql.SQLException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        try {
            new MedicalOfficeFrame().setVisible(true);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        Service service = new Service();

        PacientsDatabase dbP = PacientsDatabase.getDatabaseInstance();
        DoctorsDatabase dbD = DoctorsDatabase.getDatabaseInstance();
        AppointmentsDatabase dbA = AppointmentsDatabase.getDatabaseInstance1();

        //dbA.dropTable();
        //dbA.addAppointment(1,1,"tuse",15,"13/04/2021");
       // dbA.addAppointment(2,2,"febra",16,"15/05/2021");
        dbA.showAppointments();

        Doctor d = new Doctor(30,"Cardiologist","cardio","cardio",56,"99","$$");
        Doctor d1 = new Doctor(30,"Dentist","dentist","dentist",78,"88","$");
        Doctor d2 = new Doctor(7,"Psychologist","psycho","psycho",80,"99","$$$");

        Doctor d4 = new Doctor(260,"Cardiologist","","",90,"","");
        System.out.println(d4.toString());
        //dbD.addDoctor(d4);
        //dbD.addDoctor(d);
        //dbD.addDoctor(d1);
        //dbD.addDoctor(d2);
        dbD.showDoctors();

        List<Doctor> dds = DoctorsDatabase.Read();
        System.out.println(dds);

        //dbD.dropTable();
        //dbD.addDoctor(30,"nume","prenume",68,"0758354671","$$");
        //dbD.showDoctors();


        //dbP.dropTable();
        //dbP.addPacient(2,"a","b","c",true,false);
        //dbP.addPacient(18,"a","b","c",true,false);
        //dbP.showPacients();
        List<Pacient> pacients = PacientsDatabase.Read();



        //db.updatePacient("a","Bianca","AGE","30");
        //db.showPacients();

        loop:
        while(true){
            System.out.println("1. Serviciu pacienti");
            System.out.println("2. Serviciu doctori");
            System.out.println("3. Serviciu progrmari");
            System.out.println("4. Iesire");

            Scanner scan = new Scanner(System.in);
            switch(scan.nextInt()){
                case 1:{
                    service.servicePacients();
                    break;
                }
                case 2:{
                    service.serviceDoctors();
                    break;
                }
                case 3:{
                    service.serviceAppointments();
                    break;
                }
                case 4:{
                    System.exit(0);
                }
                default:{
                    System.out.println("Optiune invalida");
                }
            }
        }
    }
}
