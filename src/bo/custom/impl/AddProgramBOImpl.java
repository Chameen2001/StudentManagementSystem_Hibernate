package bo.custom.impl;

import bo.custom.AddProgramBO;
import dao.custom.ProgramDAO;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;
import entity.Program;

public class AddProgramBOImpl implements AddProgramBO {
    ProgramDAO programDAO = new ProgramDAOImpl();
    @Override
    public boolean add(ProgramDTO programDTO) throws Exception {
        return programDAO.add(new Program(programDTO.getP_id(),programDTO.getName(),programDTO.getDuration(),programDTO.getFee()));
    }
}
