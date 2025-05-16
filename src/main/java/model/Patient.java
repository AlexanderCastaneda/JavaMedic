package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {

    private String brithday, tipeBlood;
    private double weith, heigth;

    private ArrayList<AppointmenDoctor> appointmenDoctors = new ArrayList<>();
    private ArrayList<AppointmenNurse> appointmenNurses = new ArrayList<>();

    public ArrayList<AppointmenDoctor> getAppointmenDoctors() {
        return appointmenDoctors;
    }

    public void addAppointmenDoctors(Doctor doctor, Date date, String time) {
        AppointmenDoctor appointmenDoctor = new AppointmenDoctor(this, doctor);
        appointmenDoctor.schedule(date, time);
        appointmenDoctors.add(appointmenDoctor);
    }

    public ArrayList<AppointmenNurse> getAppointmenNurses() {
        return appointmenNurses;
    }

    public void setAppointmenNurses(ArrayList<AppointmenNurse> appointmenNurses) {
        this.appointmenNurses = appointmenNurses;
    }

    public Patient(String name, String email){
        super(name, email);
    }

    public void setWeith(double weith){
        this.weith = weith;
    }

    public String getWeith() {
        return this.weith + " Kg.";
    }

    public String getHeigth() {
        return this.heigth + " m";
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getTipeBlood() {
        return tipeBlood;
    }

    public void setTipeBlood(String tipeBlood) {
        this.tipeBlood = tipeBlood;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + brithday + "\nweith: " + getWeith() + "\nHeigth: " + getHeigth() + "\nTipe Blood: " + tipeBlood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo desde naciemitno");
    }
}