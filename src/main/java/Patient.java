public class Patient extends User {

    private String brithday, tipeBlood;
    private double weith, heigth;

    Patient(String name, String email){
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
}