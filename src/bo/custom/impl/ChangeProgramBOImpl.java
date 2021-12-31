package bo.custom.impl;

import bo.custom.ChangeProgramBO;
import dao.custom.ProgramDAO;
import dao.custom.StudentProgramDetailDAO;
import dao.custom.impl.ProgramDAOImpl;
import dao.custom.impl.StudentProgramDetailDAOImpl;
import dto.ProgramDTO;
import entity.Program;

import java.util.ArrayList;

public class ChangeProgramBOImpl implements ChangeProgramBO {

    StudentProgramDetailDAO studentProgramDetailDAO = new StudentProgramDetailDAOImpl();
    ProgramDAO programDAO = new ProgramDAOImpl();

    @Override
    public ArrayList<ProgramDTO> get_programs(String s_id) throws Exception {
        ArrayList<Program> programs = studentProgramDetailDAO.get_programs(s_id);
        ArrayList<ProgramDTO> programDTOS = new ArrayList<>();
        for (Program program : programs) {
            programDTOS.add(new ProgramDTO(program.getP_id(),program.getName(),program.getDuration(),program.getFee()));
        }
        return programDTOS;
    }

    @Override
    public ArrayList<String> get_all_programs() throws Exception {
        return programDAO.get_all_program_names();
    }

    @Override
    public ProgramDTO get_program(String program_name) throws Exception {
        Program program = programDAO.get(program_name);
        return new ProgramDTO(program.getP_id(),program.getName(),program.getDuration(),program.getFee());
    }
}
