package bo.custom.impl;

import bo.custom.AddStudentSummeryBO;
import dao.custom.StudentDAO;
import dao.custom.StudentProgramDetailDAO;
import dao.custom.impl.StudentDAOImpl;
import dao.custom.impl.StudentProgramDetailDAOImpl;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Student;
import entity.StudentProgramDetail;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.time.LocalDate;
import java.util.Date;

public class AddStudentSummeryBOImpl implements AddStudentSummeryBO{

    StudentDAO studentDAO = new StudentDAOImpl();
    StudentProgramDetailDAO studentProgramDetailDAO = new StudentProgramDetailDAOImpl();

    @Override
    public boolean add_Student(StudentDTO studentDTO) throws Exception {
        if (studentDAO.add(new Student(studentDTO.getS_id(),studentDTO.getName(),studentDTO.getB_date(),studentDTO.getNic(),studentDTO.getAddress(),studentDTO.getGender()))) {
            for (ProgramDTO programDTO : studentDTO.getProgramDTOS()) {
                if (!studentProgramDetailDAO.add(new StudentProgramDetail(new Student(studentDTO.getS_id()),new Program(programDTO.getP_id())))) {
                    System.out.println("awa athula");
                    return false;
                }
            }

        }else {
            System.out.println("awa");
            return false;
        }
        return true;
    }
}
