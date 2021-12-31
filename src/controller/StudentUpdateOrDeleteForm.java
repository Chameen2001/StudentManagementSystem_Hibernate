package controller;

import bo.custom.StudentUpdateOrDeleteBO;
import bo.custom.impl.StudentUpdateOrDeleteBOImpl;
import dto.StudentDTO;
import embeded.Name;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.StudentTM;

import java.io.IOException;
import java.util.ArrayList;

public class StudentUpdateOrDeleteForm {
    public AnchorPane add_student_context;
    public AnchorPane add_student_pane;
    public TextField txt_f_name;
    public TextField txt_m_name;
    public TextField txt_l_name;
    public TextField txt_nic;
    public TextField txt_b_date;
    public TextField txt_address;
    public TextField txt_address_2;
    public RadioButton male;
    public ToggleGroup gender;
    public RadioButton female;
    public TableView<StudentTM> tbl_student;
    public TextField txt_student_id;
    String s_id;

    StudentUpdateOrDeleteBO studentUpdateOrDeleteBO = new StudentUpdateOrDeleteBOImpl();

    public void initialize(){

        tbl_student.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("s_id"));
        tbl_student.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_student.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));

        tbl_student.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try{
                set_text_fields(newValue);
            }catch (Exception e){

            }
        });


    }

    private void set_text_fields(StudentTM selectedItem) {
        s_id = selectedItem.getS_id();
        txt_f_name.setText(selectedItem.getName().split(" ")[0]);
        txt_m_name.setText(selectedItem.getName().split(" ")[1]);
        txt_l_name.setText(selectedItem.getName().split(" ")[2]);
        txt_student_id.setText(selectedItem.getS_id());
        txt_nic.setText(selectedItem.getNic());
        txt_address.setText(selectedItem.getAddress());
        txt_b_date.setText(selectedItem.getB_date());
        if (selectedItem.getGender().equals("male")) {
            male.setSelected(true);
        }else {
            female.setSelected(true);
        }
    }

    public void update_btn_mouse_clicked(MouseEvent mouseEvent) {

        RadioButton selectedBtn = (RadioButton) gender.getSelectedToggle();
        try {
            if (studentUpdateOrDeleteBO.updateStudent(new StudentDTO(s_id,new Name(txt_f_name.getText(),txt_l_name.getText(),txt_m_name.getText()),txt_b_date.getText(),txt_nic.getText(),txt_address.getText(),selectedBtn.getText()))) {
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated",ButtonType.OK).show();
                clear_all();
            }else {
                new Alert(Alert.AlertType.ERROR,"Update Unsuccessfully",ButtonType.OK).show();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    private void clear_all() throws Exception {
        txt_student_id.clear();
        txt_f_name.clear();
        txt_m_name.clear();
        txt_l_name.clear();
        txt_b_date.clear();
        txt_nic.clear();
        txt_address.clear();
        male.setSelected(false);
        female.setSelected(false);

        ArrayList<StudentDTO> studentDTOS = studentUpdateOrDeleteBO.getAllStudent();
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();
        for (StudentDTO studentDTO : studentDTOS) {
            studentTMS.add(new StudentTM(studentDTO.getS_id(),studentDTO.getName().getF_name()+" "+studentDTO.getName().getM_name()+" "+studentDTO.getName().getL_name(),studentDTO.getB_date(),studentDTO.getNic(),studentDTO.getAddress(),studentDTO.getGender()));
        }
        tbl_student.setItems(studentTMS);
    }

    public void btn_search_mouse_clicked(MouseEvent mouseEvent) {
        System.out.println("Awaaaaa");
        try {
            load_table(txt_student_id.getText());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void load_table(String s_id) throws Exception {
        StudentDTO studentDTO = studentUpdateOrDeleteBO.getStudent(s_id);
        ObservableList<StudentTM> observableList = FXCollections.observableArrayList();
        observableList.add(new StudentTM(studentDTO.getS_id(),studentDTO.getName().getF_name()+" "+studentDTO.getName().getM_name()+" "+studentDTO.getName().getL_name(),studentDTO.getB_date(),studentDTO.getNic(),studentDTO.getAddress(),studentDTO.getGender()));
        tbl_student.setItems(observableList);
    }

    public void change_program_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ChangeProgramForm.fxml"));
        Parent load = fxmlLoader.load();
        ChangeProgramForm controller = fxmlLoader.getController();
        controller.setController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.show();
    }

    public void delete_btn_mouse_clicked(MouseEvent mouseEvent) {
        try {
            if (studentUpdateOrDeleteBO.deleteStudent(tbl_student.getSelectionModel().getSelectedItem())) {
                clear_all();
                new Alert(Alert.AlertType.CONFIRMATION,"Removing Student Success",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Removing Student Error",ButtonType.OK).show();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }



    public void get_gender(ActionEvent actionEvent) {

    }
}
