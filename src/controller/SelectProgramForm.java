package controller;

import bo.custom.SelectProgramBO;
import bo.custom.impl.SelectProgramBOImpl;
import dto.ProgramDTO;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.tm.ProgramTM;

import java.io.IOException;

public class SelectProgramForm {
    public AnchorPane add_student_pane;
    public Pane next_btn;
    public ComboBox<String> program_cmb;
    public Pane add_btn;
    public TableView<ProgramTM> tbl_selected_program;
    public AddStudentDetailForm addStudentDetailForm;

    ObservableList<ProgramTM> programTMS = FXCollections.observableArrayList();

    SelectProgramBO selectProgramBO = new SelectProgramBOImpl();

    public void initialize(){

        tbl_selected_program.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("p_id"));
        tbl_selected_program.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_selected_program.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tbl_selected_program.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));
        tbl_selected_program.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("delete"));


        try {
            program_cmb.setItems(FXCollections.observableArrayList(selectProgramBO.get_all_program_names()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void next_btn_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        addStudentDetailForm.add_student_context.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddStudentSummeryForm.fxml"));
        Parent load = fxmlLoader.load();
        AddStudentSummeryForm controller = fxmlLoader.getController();
        controller.setController(this);
        Scene scene = addStudentDetailForm.add_student_context.getScene();

        load.translateXProperty().set(scene.getWidth());
        addStudentDetailForm.add_student_context.getChildren().add(load);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(400),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void add_btn_mouse_clicked(MouseEvent mouseEvent) {

        try {
            load_table(program_cmb.getSelectionModel().getSelectedItem());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void load_table(String program_name) throws Exception {
        for (int i =0; i<programTMS.size(); i++){
            if (programTMS.get(i).getName().equals(program_name)){
                new Alert(Alert.AlertType.WARNING,"This Program Is Already Chosen", ButtonType.OK).show();
                return;
            }
        }
        ProgramDTO programDTO = selectProgramBO.get(program_name);
        Button delete = new Button("Delete");
        ProgramTM programTM = new ProgramTM(programDTO.getP_id(), programDTO.getName(), programDTO.getDuration(), programDTO.getFee(), delete);
        programTMS.add(programTM);
        delete.setOnAction(event -> {
            programTMS.remove(programTM);
        });
        tbl_selected_program.setItems(programTMS);
    }

    public void setController(AddStudentDetailForm addStudentDetailForm) {
        this.addStudentDetailForm = addStudentDetailForm;
    }
}
