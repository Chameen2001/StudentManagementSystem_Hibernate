package dao.custom;

import dao.CrudDAO;
import entity.Student;

public interface StudentDAO extends CrudDAO<Student,String> {

    String generate_new_student_id();
}
