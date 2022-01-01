package dto;

import entity.Program;
import entity.Student;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


public class StudentProgramDetailDTO {
    String student_id;
    String program_id;

    public StudentProgramDetailDTO() {
    }

    public StudentProgramDetailDTO(String student_id, String program_id) {
        this.student_id = student_id;
        this.program_id = program_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }
}
