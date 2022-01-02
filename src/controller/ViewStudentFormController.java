package controller;

import bo.custom.impl.ViewStudentBOImpl;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTM;

import java.util.ArrayList;

public class ViewStudentFormController {
    public TableView<StudentTM> tbl_student_detail;
    ViewStudentBOImpl viewStudentBO = new ViewStudentBOImpl();

    public void initialize(){

        tbl_student_detail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("s_id"));
        tbl_student_detail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_student_detail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tbl_student_detail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));

        try {
            load_table();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void load_table() throws Exception {
        ArrayList<StudentDTO> studentDTOS = viewStudentBO.getAllStudent();
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();
        for (StudentDTO studentDTO : studentDTOS) {
            studentTMS.add(new StudentTM(studentDTO.getS_id(),studentDTO.getName().getF_name()+" "+studentDTO.getName().getM_name()+" "+studentDTO.getName().getL_name(),studentDTO.getB_date(),studentDTO.getNic(),studentDTO.getAddress(),studentDTO.getGender()));
        }
        tbl_student_detail.setItems(studentTMS);
    }
}
