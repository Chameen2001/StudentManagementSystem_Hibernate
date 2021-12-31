package dao.custom;

import dao.CrudDAO;
import entity.Program;

import java.util.ArrayList;

public interface ProgramDAO extends CrudDAO<Program,String>{
    ArrayList<String> get_all_program_names() throws Exception;
}
