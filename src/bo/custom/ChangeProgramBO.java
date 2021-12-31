package bo.custom;

import dto.ProgramDTO;

import java.util.ArrayList;

public interface ChangeProgramBO {
    ArrayList<ProgramDTO> get_programs(String s_id) throws Exception;

    ArrayList<String> get_all_programs()throws Exception;

    ProgramDTO get_program(String program_name)throws Exception;
}
