package controller;

import bo.custom.ChangeProgramBO;
import bo.custom.impl.ChangeProgramBOImpl;
import dto.ProgramDTO;
import dto.StudentProgramDetailDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.tm.ProgramTM;

import java.util.ArrayList;

public class ChangeProgramForm {

    public ComboBox<String> program_cmb;
    public TableView<ProgramTM> tbl_selected_program;
    public Pane add_btn;
    private StudentUpdateOrDeleteForm studentUpdateOrDeleteForm;
    ObservableList<ProgramTM> programTMS = FXCollections.observableArrayList();

    ChangeProgramBO changeProgramBO = new ChangeProgramBOImpl();

    public void initialize(){

        tbl_selected_program.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("p_id"));
        tbl_selected_program.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_selected_program.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tbl_selected_program.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));
        tbl_selected_program.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("delete"));

        try {
            ArrayList<String> programDTOS = changeProgramBO.get_all_programs();
            program_cmb.setItems(FXCollections.observableArrayList(programDTOS));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void update_btn_mouse_clicked(MouseEvent mouseEvent) {

        ArrayList<StudentProgramDetailDTO> studentProgramDetailDTOS = new ArrayList<>();
        for (ProgramTM item : tbl_selected_program.getItems()) {
            studentProgramDetailDTOS.add(new StudentProgramDetailDTO(studentUpdateOrDeleteForm.s_id,item.getP_id()));
        }
        try {
            if (changeProgramBO.update_programs(studentProgramDetailDTOS)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Update Successfully",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Update Unsuccessfully",ButtonType.OK).show();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void add_btn_mouse_clicked(MouseEvent mouseEvent) {
        try {
            add_to_table(program_cmb.getSelectionModel().getSelectedItem());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void add_to_table(String program_name) throws Exception {
        for (int i =0; i<programTMS.size(); i++){
            if (programTMS.get(i).getName().equals(program_name)){
                new Alert(Alert.AlertType.WARNING,"This Program Is Already Chosen", ButtonType.OK).show();
                return;
            }
        }
        ProgramDTO programDTO = changeProgramBO.get_program(program_name);
        Button delete = new Button("Delete");
        ProgramTM programTM = new ProgramTM(programDTO.getP_id(), programDTO.getName(), programDTO.getDuration(), programDTO.getFee(), delete);
        programTMS.add(programTM);
        delete.setOnAction(event -> {
            programTMS.remove(programTM);
        });
        tbl_selected_program.setItems(programTMS);
    }

    public void setController(StudentUpdateOrDeleteForm studentUpdateOrDeleteForm) {
        this.studentUpdateOrDeleteForm=studentUpdateOrDeleteForm;
        try {
            load_table();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void load_table() throws Exception {

        ArrayList<ProgramDTO> programs = changeProgramBO.get_programs(studentUpdateOrDeleteForm.s_id);
        for (ProgramDTO program : programs) {
            Button delete = new Button("Delete");
            ProgramTM programTM = new ProgramTM(program.getP_id(), program.getName(), program.getDuration(), program.getFee(), delete);
            programTMS.add(programTM);
            delete.setOnAction(event -> {
                programTMS.remove(programTM);
            });
        }
        tbl_selected_program.setItems(programTMS);
    }
}
