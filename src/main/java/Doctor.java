import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;

    Doctor(String name, String email){
        super(name, email);
        this.speciality = speciality;

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //USO DE CLASES ESTATICAS ANIDADAS
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEspeciality: " + speciality + "\n Appointments..." + availableAppointments.toString();
    }

    public static class AvailableAppointment{
        //Avoiable Appointment
        private int idAvailavleAppointment;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time){
            this.date = date;
            this.time = time;
        }

        public int getIdAvailavleAppointment() {
            return idAvailavleAppointment;
        }

        public void setIdAvailavleAppointment(int idAvailavleAppointment) {
            this.idAvailavleAppointment = idAvailavleAppointment;
        }

        public Date getDate() {
            return date;
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
