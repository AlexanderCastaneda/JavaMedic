import ui.UiMenu;

import java.util.Date;

import static ui.UiMenu.*;

public class Main {
    public static void main(String[] args) {
       Doctor myDoctor1 = new Doctor("Gato Dormilon", "gatodormilon@outlook.com");
       myDoctor1.addAvailableAppointment(new Date(), "4Pm");
        myDoctor1.addAvailableAppointment(new Date(), "10Am");
        myDoctor1.addAvailableAppointment(new Date(), "1Pm");

        // impresion de clase estática anidada =D
       /*for (Doctor.AvailableAppointment aA: myDoctor1.getAvailableAppointments()){
            System.out.println(aA.getDate() + ", " + aA.getTime());
        }*/
       Patient patient1 = new Patient("Gato Enfermito", "soyungatoefermito@gmail.com");
        System.out.println(patient1);

        System.out.println(myDoctor1);
        //UiMenu menu = new UiMenu();
        showMenu();
    }
}