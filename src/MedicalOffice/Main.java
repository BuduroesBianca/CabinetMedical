package MedicalOffice;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Service service = new Service();

        Pacient p1 = new Pacient(0,20,"Luca","Andreea", new Vector<String>(Arrays.asList("tuse")) ,false,false);
        Pacient p2 = new Pacient(1,15,"Popa","Ioana", new Vector<String>(Arrays.asList("dermatita")) ,true,true);
        Pacient p3 = new Pacient(2,17,"Andra","Matei", new Vector<String>(Arrays.asList("tuse","febra")) ,true,false);
        Pacient p4 = new Pacient(3,34,"Manea","Cristina", new Vector<String>(Arrays.asList("tuse")) ,false,false);
        Pacient p5 = new Pacient(4,22,"Curelaru","Catalin", new Vector<String>(Arrays.asList("tuse")) ,true,true);
        Pacient p6 = new Pacient(5,13,"Dandu","Adrian", new Vector<String>(Arrays.asList("dureri de cap,ameteala")) ,true,false);
        Pacient p7 = new Pacient(6,67,"Romila","Mircea", new Vector<String>(Arrays.asList("tuse,dureri de cap")) ,false,true);


        service.getPacients().add(p1);
        service.getPacients().add(p2);
        service.getPacients().add(p3);
        service.getPacients().add(p4);
        service.getPacients().add(p5);
        service.getPacients().add(p6);
        service.getPacients().add(p7);


        Dentist d1 = new Dentist(0,20,"Donciu","Claudia",46,"07683564910","$$");
        Cardiologist c1 = new Cardiologist(1,30,"Necula","Elena",60,"07683564910","$$$");
        Dermatologist dd1 = new Dermatologist(2,7,"Donciu","Claudia",32,"07683564910","$");
        Psychologist psih1 = new Psychologist(3,25,"Neamtu","Narcisa",57,"0648295638","$$");
        Cardiologist c2 = new Cardiologist(4,35,"Cuciuc","Serafim",67,"07683564910","$$$$");
        Dentist d2 = new Dentist(0,5,"Podariu","Isabel",32,"07683564910","$$");


        service.getDoctors().add(d1);
        service.getDoctors().add(c1);
        service.getDoctors().add(dd1);
        service.getDoctors().add(c2);
        service.getDoctors().add(d2);

        SimpleDateFormat data = new SimpleDateFormat("dd/mm/yyyy");

        Appointment a1 = new Appointment(0,2,"dermatita",15,data.parse("15/05/2021"));
        Appointment a2 = new Appointment(1,2,"acnee",16,data.parse("15/05/2021"));
        Appointment a3 = new Appointment(5,3,"depresie",17,data.parse("15/05/2021"));
        Appointment a4 = new Appointment(3,4,"presiune arteriala",15,data.parse("15/02/2021"));
        Appointment a5 = new Appointment(2,2,"dermatita",16,data.parse("15/02/2021"));
        Appointment a6 = new Appointment(6,1,"rutina",17,data.parse("15/02/2021"));
        Appointment a7 = new Appointment(1,2,"dermatita",14,data.parse("15/02/2021"));
        Appointment a8 = new Appointment(7,3,"depresie",15,data.parse("15/06/2021"));
        Appointment a9 = new Appointment(4,4,"rutina",16,data.parse("15/06/2021"));
        Appointment a10 = new Appointment(2,2,"arsuri",17,data.parse("15/06/2021"));

        service.getAppointments().add(a1);
        service.getAppointments().add(a2);
        service.getAppointments().add(a3);
        service.getAppointments().add(a4);
        service.getAppointments().add(a5);
        service.getAppointments().add(a6);
        service.getAppointments().add(a7);
        service.getAppointments().add(a8);
        service.getAppointments().add(a9);
        service.getAppointments().add(a10);


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
