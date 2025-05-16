package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Doctor(String name, String email){
        super(name, email);
        this.speciality = speciality;

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEspeciality: " + speciality + "\n Appointments..." + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Gatitos adoloridos");
        System.out.println("Departamento: Cancerologia");
    }

    public static class AvailableAppointment{
        //Avoiable Appointment
        private int idAvailavleAppointment;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        public AvailableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public int getIdAvailavleAppointment() {
            return idAvailavleAppointment;
        }

        public void setIdAvailavleAppointment(int idAvailavleAppointment) {
            this.idAvailavleAppointment = idAvailavleAppointment;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \nDate: " + date + "\nTime: " + time;
        }
    }
}
