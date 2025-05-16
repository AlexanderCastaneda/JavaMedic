package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatienteMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UiMenu.patientLogget.getName());
            System.out.println("1. Book an appointments");
            System.out.println("2. My apponintments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentmenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 3:
                    UiMenu.showMenu();
            }

        }while (response != 0);
    }

    private static void showBookAppointmentmenu(){
        int response = 0;
        do {
            System.out.println(":: Book an appointment");
            System.out.println(":: Select date: ");
            //numeracion de la lista de fechas
            //indice de la fecha seleccionada
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment>availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");
            for (Map.Entry<Integer, Doctor> doc: doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". TIme" +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. Yes ª\n. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UiMenu.patientLogget.addAppointmenDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                showPatienteMenu();
            }


        }while (response !=0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println(":: My Appointments");
            if (UiMenu.patientLogget.getAppointmenDoctors().size() == 0){
                System.out.println("Don't have appointments");
                break;
            }
            for (int i = 0; i < UiMenu.patientLogget.getAppointmenDoctors().size(); i++){
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " +
                        UiMenu.patientLogget.getAppointmenDoctors().get(i).getDate() +
                        " Time: " +
                        UiMenu.patientLogget.getAppointmenDoctors().get(i).getTime() +
                        "\n Doctor: " +
                        UiMenu.patientLogget.getAppointmenDoctors().get(i).getDoctor().getName()
                );
            }
            System.out.println("0. return");
        }while(response != 0);
    }
}
