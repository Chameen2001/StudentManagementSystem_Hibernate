package bo.custom.impl;

import bo.custom.AddStudentDetailBO;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;

public class AddStudentDetailBOImpl implements AddStudentDetailBO {
    StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public String generate_new_student_id() {
        return studentDAO.generate_new_student_id();
    }
}
