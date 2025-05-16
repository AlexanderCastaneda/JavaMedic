package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UiMenu.doctorLogged.getName());
            System.out.println("1. Add Avalilable Appointment");
            System.out.println("2. My Scheduled apponintments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 3:
                    UiMenu.showMenu();
            }
        } while (response != 0);
    }

    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println("::Add Availabel Appointment");
            System.out.println(":: Select a Month");

            for(int i = 0; i < 3; i++){
                int j = i + 1;
                System.out.println(j + ". " + UiMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if(response > 0 && response < 4){
                int monthSelected = response;
                System.out.println(monthSelected + ". " + UiMenu.MONTHS[monthSelected-1]);
                System.out.println("insert the date availabel: [dd/mm/yy7y");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int respnseTime = 0;
                String time = "";
                do {
                    System.out.println("Inserte the time availabe for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change time");
                    respnseTime = Integer.valueOf(sc.nextLine());

                }while (respnseTime == 2);

                UiMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UiMenu.doctorLogged);

            } else if (response == 0 ) {
                showDoctorMenu();
            }
        }while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0
        && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
