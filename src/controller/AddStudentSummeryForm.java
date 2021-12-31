package controller;

import bo.custom.AddStudentSummeryBO;
import bo.custom.impl.AddStudentSummeryBOImpl;
import dto.ProgramDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import view.tm.ProgramTM;

import java.util.ArrayList;

public class AddStudentSummeryForm {
    public AnchorPane add_student_pane;
    public Pane btn_enroll;
    public TableView<ProgramTM> tbl_program;
    public Label lbl_name;
    public Label lbl_birth_date;
    public Label lbl_nic;
    public Label lbl_address;
    private SelectProgramForm selectProgramForm;

    AddStudentSummeryBO addStudentSummeryBO = new AddStudentSummeryBOImpl();

    public void initialize(){

    }

    public void enroll_btn_mouse_clicked(MouseEvent mouseEvent) {
        StudentDTO studentDTO = selectProgramForm.addStudentDetailForm.studentDTO;
        ArrayList<ProgramDTO> programDTOS = new ArrayList<>();
        for (ProgramTM programTM : selectProgramForm.programTMS) {
            programDTOS.add(new ProgramDTO(programTM.getP_id(),programTM.getName(),programTM.getDuration(),programTM.getFee()));
        }
        studentDTO.setProgramDTOS(programDTOS);
        try {
            if (addStudentSummeryBO.add_Student(studentDTO)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Added!", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong by adding registered program", ButtonType.OK).show();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setController(SelectProgramForm selectProgramForm) {
        this.selectProgramForm=selectProgramForm;
        load_data();
    }

    private void load_data() {
        StudentDTO studentDTO = selectProgramForm.addStudentDetailForm.studentDTO;
        lbl_name.setText(studentDTO.getName().getF_name()+" "+studentDTO.getName().getM_name()+" "+studentDTO.getName().getL_name());
        lbl_birth_date.setText(studentDTO.getB_date());
        lbl_address.setText(studentDTO.getAddress());
        lbl_nic.setText(studentDTO.getNic());

        tbl_program.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("p_id"));
        tbl_program.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_program.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tbl_program.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));


        tbl_program.setItems(selectProgramForm.programTMS);
    }
}
