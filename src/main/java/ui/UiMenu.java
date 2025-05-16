package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {

    public static String[] MONTHS ={"Enero", "Febrero", "Marzo", "Abirl", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogget;

    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;

        do {
            System.out.println("1. Doctor");
            System.out.println("2.Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    response = 0;
                    break;
                case 2:
                   authUser(2);
                    response = 0;
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        //userType = 1 es un doctor
        //userTupe = 2 es un paciente
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Andres Paez", "andres@gmail.com"));
        doctors.add(new Doctor("Carolina Bohorquez", "carolina@gmail.com"));
        doctors.add(new Doctor("Epifanio Colastico", "epifanio@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Carlos perez", "carlos@gmail.com"));
        patients.add(new Patient("Jhonata Castro", "jhonatan@gmail.com"));
        patients.add(new Patient("Celso Duran", "Celso@gmail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [esteesunejmeplo@.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1){
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener los datos de usuario logeado
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2){
                for (Patient pa: patients){
                    if (pa.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener los dato del usuario legeado
                        patientLogget = pa;
                        UIPatientMenu.showPatienteMenu();
                    }
                }
            }

        }while (!emailCorrect);
    }

    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++){
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}
