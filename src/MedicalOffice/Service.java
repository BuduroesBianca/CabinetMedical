package MedicalOffice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.*;
import java.time.LocalDateTime;
import java.text.ParseException;

public class Service {

    private Vector<Pacient> Pacients= new Vector<Pacient>();
    private Vector<Doctor> Doctors = new Vector<Doctor>();
    private Vector<Appointment> Appointments = new Vector<Appointment>();

    Service(){}

    public Vector<Appointment> getAppointments() {
        return Appointments;
    }

    public void setAppointments(Vector<Appointment> appointments) {
        Appointments = appointments;
    }

    public Vector<Pacient> getPacients() {
        return Pacients;
    }

    public void setPacients(Vector<Pacient> pacients) {
        Pacients = pacients;
    }

    public Vector<Doctor> getDoctors() {
        return Doctors;
    }

    public void setDoctors(Vector<Doctor> doctors) {
        Doctors = doctors;
    }

    public void servicePacients() {

        System.out.println("Alegeti una din urmatoarele actiuni: ");
        System.out.println("1.Afisare pacienti in ordine alfabetica");
        System.out.println("2.Afisare pacienti minori");
        System.out.println("3.Afiseaza informatii despre un anumit pacient");
        System.out.println("4.Afiseaza toti pacientii fara asigurare medicala");
        System.out.println("5.Afisati pacientii ce au virusul Covid-19");
        System.out.println("6.Adauga un nou pacient in baza de date");
        System.out.println("7. Sterge un pacient din baza de date");

        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1: {
                Collections.sort(Pacients, new Comparator<Pacient>() {
                    @Override
                    public int compare(Pacient o1, Pacient o2) {
                        return o1.getFirstName().compareTo(o2.getFirstName());
                    }
                });

                for(Pacient it: Pacients)
                    System.out.println(it.toString());
                break;
            }
            case 2:{
                for(Pacient it:Pacients)
                    if(it.isChild()) {
                        System.out.println(it.toString());
                    }
                break;
            }
            case 3:{
                System.out.println("Introduceti numele pacientului:");
                String firstName = scan.next();
                System.out.println("Introduceti prenumele pacientului:");
                String lastName = scan.next();

                int found = 0;
                for(Pacient it:Pacients)
                    if(it.getFirstName().equals(firstName) && it.getLastName().equals(lastName)) {
                        System.out.println(it.toString());
                        found = 1;
                    }
                if(found == 0)
                    System.out.println("Pacientul nu a fost gasit.");
                break;
            }
            case 4:{
                int found = 0;
                for(Pacient it:Pacients){
                    if(it.hasInsurance() == false) {
                        System.out.println(it.toString());
                        found = 1;
                    }
                }
                if(found == 0)
                    System.out.println("Toti pacientii inregistrati au asigurare medicala.");
                break;
            }
            case 5:{
                int found = 0;
                for(Pacient it:Pacients){
                    if(it.hasCovid() == true) {
                        System.out.println(it.toString());
                        found = 1;
                    }
                }
                if(found == 0)
                    System.out.println("Niciun pacient inregistrat nu are Covid-19");
                break;
            }
            case 6:{
                int id = Pacients.size()+1;
                System.out.println("Completati urmatorul formular:");
                System.out.println("Nume:");
                String firstName = scan.next();
                System.out.println("Prenume");
                String lastName = scan.next();
                System.out.println("Varsta");
                int age = scan.nextInt();
                System.out.println("Detine asigurare? True/False");
                boolean insurance = scan.nextBoolean();
                System.out.println("Are testul Covid-19 facut? True/False");
                boolean covidTest = scan.hasNextBoolean();
                Vector<String> symptoms = new Vector<String>();
                Pacient pAdd = new Pacient(id,age,firstName,lastName,symptoms,insurance,covidTest);
                Pacients.add(pAdd);
                System.out.println("Pacientul " + pAdd.toString() + " a fost adaugat cu succes");
                break;
            }
            case 7:{
                System.out.println("Introduceti numele pacientului pe care doriti sa il stergeti:");
                String firstName = scan.next();
                System.out.println("Introduceti prenumele:");
                String lastName = scan.next();

                Pacient objToDelete = new Pacient();
                int found = 0;
                for(Pacient it:Pacients)
                    if(it.getLastName().equals(lastName) && it.getFirstName().equals(firstName)){
                        found = 1;
                        objToDelete = it;
                    }

                if(found == 0) {
                    System.out.println("Acest pacient nu a fost gasit");
                    Pacients.remove(objToDelete);
                }
                else
                    System.out.println("Acest pacient a fost sters cu succes");
                break;
            }
            default:{
                System.out.println("Optiunea nu este valida");
            }
        }
    }

    public void serviceDoctors(){

        System.out.println("Alegeti una din urmatoarele actiuni");
        System.out.println("1. Afisare doctori");
        System.out.println("2. Afisare medici in functie de specializare");
        System.out.println("3. Afisarea doctori sortati descrescator dupa anii de experienta");
        System.out.println("4. Adaugati un doctor");
        System.out.println("5. Stergeti un doctor");

        Scanner scan = new Scanner(System.in);
        int op = scan.nextInt();
        switch (op) {
            case 1:{
                for(Doctor it: Doctors)
                    System.out.println(it.toString());
                break;
            }
            case 2:{
                System.out.println("Ce tip de medic cautati?");
                System.out.println("1.Cardiolog");
                System.out.println("2. Dermatolog");
                System.out.println("3. Dentist");
                System.out.println("4. Psiholog");
                int op1 = scan.nextInt();
                switch (op1){
                    case 1:{
                        for(Doctor it: Doctors){
                            if(it instanceof Cardiologist)
                                System.out.println(it.toString());
                            }
                        break;
                    }
                    case 2:{
                        for(Doctor it: Doctors){
                            if(it instanceof Dermatologist)
                                System.out.println(it.toString());
                        }
                        break;
                    }
                    case 3:{
                        for(Doctor it: Doctors){
                            if(it instanceof Dentist)
                                System.out.println(it.toString());
                        }
                        break;
                    }
                    case 4:{
                        for(Doctor it: Doctors){
                            if(it instanceof Psychologist)
                                System.out.println(it.toString());
                        }
                        break;
                    }
                    default:{
                        System.out.println("Optiunea nu este valida");
                    }
                }
                break;
            }
            case 3:{
                Collections.sort(Doctors, new Comparator<Doctor>() {
                    @Override
                    public int compare(Doctor o1, Doctor o2) {
                        return o2.getYearsOfExperience() - o1.getYearsOfExperience();
                    }
                });
                for(Doctor it:Doctors)
                    System.out.println(it.toString());
                break;
            }
            case 4:{
                System.out.println("Completati urmatorul formular");
                System.out.println("Nume doctor:");
                String firstName = scan.next();
                System.out.println("Prenume doctor");
                String lastName = scan.next();
                System.out.println("Specializare(Cardiologist, Dermatologist, Psychologist,Dentist):");
                String type = scan.next();
                System.out.println("Ani de experienta");
                int experience = scan.nextInt();
                System.out.println("Varsta");
                int age = scan.nextInt();
                System.out.println("Numar de telefon:");
                String nrTel = scan.next();
                System.out.println("Intervalul de pret:");
                String priceRange = scan.next();
                int id = Doctors.size()+1;

                switch(type){
                    case "Cardiologist":{
                        Cardiologist obj = new Cardiologist(id,experience,firstName,lastName,age,nrTel,priceRange);
                        Doctors.add(obj);
                        break;
                    }
                    case "Dermatologist":{
                        Dermatologist obj = new Dermatologist(id,experience,firstName,lastName,age,nrTel,priceRange);
                        Doctors.add(obj);
                        break;
                    }
                    case "Dentist":{
                        Dentist obj = new Dentist(id,experience,firstName,lastName,age,nrTel,priceRange);
                        Doctors.add(obj);
                        break;
                    }
                    case "Psychologist":{
                        Psychologist obj = new Psychologist(id,experience,firstName,lastName,age,nrTel,priceRange);
                        Doctors.add(obj);
                        break;
                    }
                }
                System.out.println("Medicul a fost adaugat cu succes");
                break;
            }
            case 5:{
                System.out.println("Introduceti numele medicului");
                String firstName = scan.next();
                System.out.println("Introduceti prenumele");
                String lastName = scan.next();

                Doctor objToDelete = new Doctor();
                int found = 0;
                for(Doctor it:Doctors)
                    if(it.getFirstName().equals(firstName) && it.getLastName().equals(lastName)){
                        found = 1;
                        objToDelete = it;
                    }
                if(found == 1) {
                    Doctors.remove(objToDelete);
                    System.out.println("Doctorul a fost sters cu succes");
                }
                else
                    System.out.println("Doctorul nu este inregistrat in baza de date");
                break;
            }
        }
    }

    public void serviceAppointments() throws ParseException {

        System.out.println("Alege una din urmatoarele actiuni:");
        System.out.println("1.Afisare programari ce vor urma");
        System.out.println("2.Afisare programari asignate unui doctor specificat");
        System.out.println("3.Adauga o programare");
        System.out.println("4.Modifica data unei programari");
        System.out.println("5.Anuleaza o programare");
        Scanner scan = new Scanner(System.in);
        int op = scan.nextInt();
        switch(op){
            case 1:{
                SimpleDateFormat dtf = new SimpleDateFormat("dd/mm/yyyy");
                String data = new Date().toString();
                Date today = dtf.parse(data);
                for(Appointment it: Appointments){
                    if(it.getDate().after(today))
                        System.out.println(it.toString());
                }
                break;
            }
            case 2:{
                System.out.println("Introduceti numele doctorului:");
                String firstName = scan.next();
                System.out.println("Introduceti prenumele");
                String lastName = scan.next();

                int id = -1;

                for(Doctor it:Doctors)
                    if(it.getLastName().equals(lastName) && it.getFirstName().equals(firstName))
                        id = it.getId();
                if(id == -1)
                    System.out.println("Doctorul specificat nu a fost gasit");
                else{
                    for(Appointment it:Appointments)
                        if(it.getIdDoctor() == id)
                            System.out.println(it.toString());
                }
                break;
            }
            case 3:{
                //TO DO verificare daca exista id-urile
                SimpleDateFormat dtf = new SimpleDateFormat("dd/mm/yyyy");
                System.out.println("Completati urmatorul formular");
                System.out.println("Id-ul pacientului pentru care doriti sa faceti programarea");
                int idPacient = scan.nextInt();
                System.out.println("Id-ul doctorului unde doriti sa asignati pacientul");
                int idDoctor = scan.nextInt();
                System.out.println("Motivul programarii");
                String motive = scan.next();
                System.out.println("Data la care doriti sa faceti progrmarea? dd/mm/yyyy");
                String date = scan.next();
                Date data = dtf.parse(date);
                System.out.println("Introduceti ora");
                int hour = scan.nextInt();

                Appointment newA = new Appointment(idPacient,idDoctor,motive,hour,data);
                System.out.println("Programarea a fost efectuata cu succes");
                break;
            }
            case 4:{
                SimpleDateFormat dtf = new SimpleDateFormat("dd/mm/yyyy");
                System.out.println("Completati urmatorul formular");
                System.out.println("Id-ul pacientului care are programarea");
                int idPacient = scan.nextInt();
                System.out.println("Id-ul doctorului asignat programarii");
                int idDoctor = scan.nextInt();
                System.out.println("Motivul programarii");
                String motive = scan.next();
                System.out.println("Data la care era stabilita programarea dd/mm/yyyy");
                String date = scan.next();
                Date data = dtf.parse(date);
                System.out.println("Ora la care era stabilita programarea");
                int hour = scan.nextInt();

                int found = 1;
                for(Appointment it:Appointments){
                    if(it.getIdPacient() == idPacient && it.getIdDoctor() == idDoctor &&
                            it.getMotive().equals(motive) && it.getDate().equals(data) && it.getHour() == hour) {
                        System.out.println("Introduceti noua data:");
                        String date1 = scan.next();
                        Date data1 = dtf.parse(date1);
                        it.setDate(data1);
                        System.out.println("Introduceti ora");
                        int hour1 = scan.nextInt();
                        it.setHour(hour1);
                        found = 1;
                    }
                }
                if(found == 0)
                    System.out.println("Aceasta programare nu este intregistrata");
                break;
            }
            case 5:{
                SimpleDateFormat dtf = new SimpleDateFormat("dd/mm/yyyy");
                System.out.println("Completati urmatorul formular");
                System.out.println("Id-ul pacientului care avea programarea");
                int idPacient = scan.nextInt();
                System.out.println("Id-ul doctorului asignat programarii");
                int idDoctor = scan.nextInt();
                System.out.println("Motivul programarii");
                String motive = scan.next();
                System.out.println("Data la care era stabilita programarea dd/mm/yyyy");
                String date = scan.next();
                Date data = dtf.parse(date);
                System.out.println("Ora la care era stabilita programarea");
                int hour = scan.nextInt();

                Appointment objToDelete = new Appointment();
                int found = 1;
                for(Appointment it:Appointments){
                    if(it.getIdPacient() == idPacient && it.getIdDoctor() == idDoctor &&
                    it.getMotive().equals(motive) && it.getDate().equals(data) && it.getHour() == hour) {
                        objToDelete = it;
                        found = 1;
                    }
                }
                if(found == 1){
                    Appointments.remove(objToDelete);
                    System.out.println("Programarea a fost anulata cu succes");
                }
                else
                    System.out.println("Aceasta programare nu este intregistrata");
                break;
            }
        }
    }

}
