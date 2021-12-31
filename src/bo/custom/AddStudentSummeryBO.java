package bo.custom;

import dto.StudentDTO;

public interface AddStudentSummeryBO {
    boolean add_Student(StudentDTO studentDTO)throws Exception;
}
