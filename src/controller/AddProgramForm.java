package controller;

import bo.custom.AddProgramBO;
import bo.custom.impl.AddProgramBOImpl;
import dto.ProgramDTO;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import util.FactoryConfiguration;

public class AddProgramForm {
    public AnchorPane add_student_root;
    public AnchorPane add_student_context;
    public AnchorPane add_student_pane;
    public TextField txt_program_id;
    public TextField txt_program_name;
    public TextField txt_program_duration;
    public TextField txt_program_fee;

    AddProgramBO addProgramBO = new AddProgramBOImpl();

    public void add_btn_mouse_clicked(MouseEvent mouseEvent) {
        try {
            if (addProgramBO.add(new ProgramDTO(txt_program_id.getText(),txt_program_name.getText(),txt_program_duration.getText(),Double.parseDouble(txt_program_fee.getText())))){
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully", ButtonType.OK).show();
                Stage stage = (Stage) txt_program_id.getScene().getWindow();
                stage.close();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong", ButtonType.OK).show();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
