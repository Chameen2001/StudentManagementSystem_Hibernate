package bo.custom.impl;

import bo.custom.SelectProgramBO;
import dao.custom.ProgramDAO;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;
import entity.Program;

import java.util.ArrayList;

public class SelectProgramBOImpl implements SelectProgramBO {
    ProgramDAO programDAO = new ProgramDAOImpl();

    @Override
    public ArrayList<String> get_all_program_names() throws Exception {

        return programDAO.get_all_program_names();
    }

    @Override
    public ProgramDTO get(String program_name) throws Exception {
        Program program = programDAO.get(program_name);
        return new ProgramDTO(program.getP_id(),program.getName(),program.getDuration(),program.getFee());
    }
}
