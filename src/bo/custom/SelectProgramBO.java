package bo.custom;

import dto.ProgramDTO;

import java.util.ArrayList;

public interface SelectProgramBO {
    ArrayList<String> get_all_program_names() throws Exception;

    ProgramDTO get(String program_name)throws Exception;
}
