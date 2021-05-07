package MedicalOffice;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Service service = new Service();




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
