package entity;

import embeded.Name;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    String s_id;
    @Embedded
    Name name;
    String b_date;
    String nic;
    String address;
    String gender;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<StudentProgramDetail> studentProgramDetails;

    public Student() {
    }

    public Student(String s_id) {
        this.s_id = s_id;
    }

    public Student(Name name, String b_date, String nic, String address, String gender) {
        this.name = name;
        this.b_date = b_date;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
    }

    public Student(String s_id, Name name, String b_date, String nic, String address, String gender) {
        this.s_id = s_id;
        this.name = name;
        this.b_date = b_date;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
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
