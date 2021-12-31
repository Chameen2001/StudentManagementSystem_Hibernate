package controller;

import bo.custom.AddStudentDetailBO;
import bo.custom.impl.AddStudentDetailBOImpl;
import dto.StudentDTO;
import embeded.Name;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;

public class AddStudentDetailForm {

    public AnchorPane add_student_root;
    public AnchorPane add_student_context;
    public AnchorPane add_student_pane;
    public RadioButton male;
    public RadioButton female;
    public TextField txt_f_name;
    public TextField txt_m_name;
    public TextField txt_l_name;
    public TextField txt_nic;
    public TextField txt_b_date;
    public TextField txt_address;
    public TextField txt_address_2;
    StudentDTO studentDTO = new StudentDTO();
    AddStudentDetailBO addStudentDetailBO = new AddStudentDetailBOImpl();

    public void initialize(){

    }

    public void next_btn_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        get_student_data();
        add_student_context.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/SelectProgramForm.fxml"));
        Parent load = fxmlLoader.load();
        SelectProgramForm controller = fxmlLoader.getController();
        controller.setController(this);
        Scene scene = add_student_context.getScene();

        load.translateXProperty().set(scene.getWidth());
        add_student_context.getChildren().add(load);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(400),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    private void get_student_data() {
        studentDTO.setName(new Name(txt_f_name.getText(),txt_l_name.getText(),txt_m_name.getText()));
        studentDTO.setAddress(txt_address.getText());
        studentDTO.setB_date(txt_b_date.getText());
        studentDTO.setNic(txt_nic.getText());
        studentDTO.setS_id(addStudentDetailBO.generate_new_student_id());
    }

    public void get_gender(ActionEvent actionEvent) {
        if (male.isSelected()){
            studentDTO.setGender(male.getText());
        }else {
            studentDTO.setGender(female.getText());
        }
    }
}
