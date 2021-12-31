package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StudentProgramDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Integer id;
    @CreationTimestamp
    Date reg_date;
    @ManyToOne
    @JoinColumn(name = "student",referencedColumnName = "s_id")
    Student student;
    @JoinColumn(name = "program",referencedColumnName = "p_id")
    @ManyToOne
    Program program;

    public StudentProgramDetail() {
    }

    public StudentProgramDetail(Student student, Program program) {
        this.student = student;
        this.program = program;
    }

    public StudentProgramDetail(Date reg_date, Student student, Program program) {
        this.reg_date = reg_date;
        this.student = student;
        this.program = program;
    }

    public StudentProgramDetail(Integer id, Date reg_date, Student student, Program program) {
        this.id = id;
        this.reg_date = reg_date;
        this.student = student;
        this.program = program;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
