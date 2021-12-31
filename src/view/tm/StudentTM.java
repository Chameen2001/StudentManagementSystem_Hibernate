package view.tm;


public class StudentTM {

    private String s_id;
    private String name;
    private String b_date;
    private String nic;
    private String address;
    private String gender;

    public StudentTM(String s_id, String name, String b_date, String nic, String address, String gender) {
        this.setS_id(s_id);
        this.setName(name);
        this.setB_date(b_date);
        this.setNic(nic);
        this.setAddress(address);
        this.setGender(gender);
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getB_date() {
        return b_date;
    }

    public void setB_date(String b_date) {
        this.b_date = b_date;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}