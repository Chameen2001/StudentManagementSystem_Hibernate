package dao.custom;

import dao.CrudDAO;
import entity.Program;
import entity.StudentProgramDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentProgramDetailDAO extends CrudDAO<StudentProgramDetail,String> {
    ArrayList<Program> get_programs(String s_id)throws Exception;

    boolean isExists(String id)throws Exception;
}
