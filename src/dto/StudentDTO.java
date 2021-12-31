package dto;

import embeded.Name;

import java.util.ArrayList;

public class StudentDTO {
    String s_id;
    Name name;
    String b_date;
    String nic;
    String address;
    String gender;
    ArrayList<ProgramDTO> programDTOS;

    public StudentDTO() {
    }

    public StudentDTO(Name name, String b_date, String nic, String address, String gender) {
        this.name = name;
        this.b_date = b_date;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
    }

    public StudentDTO(String s_id, Name name, String b_date, String nic, String address, String gender) {
        this.s_id = s_id;
        this.name = name;
        this.b_date = b_date;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
    }

    public StudentDTO(String s_id, Name name, String b_date, String nic, String address, String gender, ArrayList<ProgramDTO> programDTOS) {
        this.s_id = s_id;
        this.name = name;
        this.b_date = b_date;
        this.nic = nic;
        this.address = address;
        this.gender = gender;
        this.programDTOS = programDTOS;
    }

    public ArrayList<ProgramDTO> getProgramDTOS() {
        return programDTOS;
    }

    public void setProgramDTOS(ArrayList<ProgramDTO> programDTOS) {
        this.programDTOS = programDTOS;
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
