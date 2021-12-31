package bo.custom.impl;

import bo.custom.StudentUpdateOrDeleteBO;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentUpdateOrDeleteBOImpl implements StudentUpdateOrDeleteBO {
    StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public StudentDTO getStudent(String s_id) throws Exception {
        Student student = studentDAO.get(s_id);
        return new StudentDTO(student.getS_id(),student.getName(),student.getB_date(),student.getNic(),student.getAddress(),student.getGender());
    }

    @Override
    public boolean deleteStudent(StudentTM selectedItem) throws Exception {
        return studentDAO.delete(selectedItem.getS_id());
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(studentDTO.getS_id(),studentDTO.getName(),studentDTO.getB_date(),studentDTO.getNic(),studentDTO.getAddress(),studentDTO.getGender()));
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws Exception {
        ArrayList<Student> students = studentDAO.getAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(new StudentDTO(student.getS_id(),student.getName(),student.getB_date(),student.getNic(),student.getAddress(),student.getGender()));
        }
        return studentDTOS;
    }
}
