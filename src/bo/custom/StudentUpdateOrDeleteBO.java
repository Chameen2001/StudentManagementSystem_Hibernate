package bo.custom;

import dto.StudentDTO;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentUpdateOrDeleteBO {
    StudentDTO getStudent(String s_id) throws Exception;

    boolean deleteStudent(StudentTM selectedItem) throws Exception;

    boolean updateStudent(StudentDTO studentDTO)throws Exception;

    ArrayList<StudentDTO> getAllStudent()throws Exception;
}
