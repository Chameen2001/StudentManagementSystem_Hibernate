package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageStudentForm {
    public AnchorPane manage_student_pane;
    public Group add_student_btn;
    public Group update_delete_program_btn;
    public Group show_detail_btn;
    public Pane back_btn;
    private homePage homePage;

    public void add_student_mouse_entered(MouseEvent mouseEvent) {

    }

    public void add_student_mouse_exited(MouseEvent mouseEvent) {
    }

    public void update_delete_program_mouse_entered(MouseEvent mouseEvent) {
    }

    public void show_details_mouse_entered(MouseEvent mouseEvent) {
    }

    public void show_details_mouse_exited(MouseEvent mouseEvent) {

    }

    public void update_delete_program_mouse_exited(MouseEvent mouseEvent) {
    }

    public void back_btn_mouse_entered(MouseEvent mouseDragEvent) {
    }

    public void back_btn_mouse_exited(MouseEvent mouseDragEvent) {

    }

    public void back_btn_mouse_clicked(MouseEvent mouseEvent) {
        homePage.main_menu_root.getChildren().clear();
        homePage.main_menu_root.getChildren().add(homePage.main_menu_panel);
    }

    public void setController(homePage homePage) {
        this.homePage=homePage;
    }

    public void add_student_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddStudentDetailForm.fxml"));
        Parent load = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();

    }

    public void update_delete_program_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/StudentUpdateOrDeleteForm.fxml"))));
        stage.show();
    }

    public void show_details_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ViewStudentForm.fxml"))));
        stage.show();
    }
}
