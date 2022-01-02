package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageProgramForm {
    public AnchorPane manage_program_pane;
    public Group add_program_btn;
    public Group update_delete_program_btn;
    public Group show_detail_btn;
    public Pane back_btn;
    private homePage homePage;

    public void add_program_mouse_exited(MouseEvent mouseEvent){

    }

    public void add_program_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/AddProgramForm.fxml")));
        stage.setScene(scene);
        stage.show();
        
    }

    public void add_program_mouse_entered(MouseEvent mouseEvent) {
        
    }

    public void update_delete_program_mouse_entered(MouseEvent mouseEvent) {
        
    }

    public void update_delete_program_mouse_exited(MouseEvent mouseEvent) {
        
    }

    public void update_delete_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ProgramUpdateOrDeleteForm.fxml"))));
        stage.show();
    }

    public void show_details_mouse_entered(MouseEvent mouseEvent) {
        
    }

    public void show_details_mouse_exited(MouseEvent mouseEvent) {
        
    }

    public void show_detail_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ViewProgramForm.fxml"))));
        stage.show();
    }

    public void back_btn_mouse_clicked(MouseEvent mouseEvent) {
        homePage.main_menu_root.getChildren().clear();
        homePage.main_menu_root.getChildren().add(homePage.main_menu_panel);
    }

    public void back_btn_mouse_entered(MouseEvent mouseEvent) {
    }

    public void back_btn_mouse_exited(MouseEvent mouseEvent) {

    }

    public void setController(homePage homePage) {
        this.homePage=homePage;
    }
}
