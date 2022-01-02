package controller;

import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.TransitionUtil;

import java.io.IOException;

public class homePage {

    public AnchorPane main_menu_panel;
    public Group manage_student_btn;
    public Group manage_program_btn;
    public Group show_detail_btn;
    public AnchorPane main_menu_root;

    public void initialize(){



    }

    public void show_details_mouse_entered(MouseEvent mouseEvent) {
        TransitionUtil.start_scale_transition(1.2,1.2,show_detail_btn,Duration.millis(100));
    }

    public void show_details_mouse_exited(MouseEvent mouseEvent) {
        TransitionUtil.start_scale_transition(1.0,1.0,show_detail_btn,Duration.millis(100));
    }

    public void manage_student_mouse_entered(MouseEvent mouseEvent) {
        TransitionUtil.start_scale_transition(1.2,1.2,manage_student_btn,Duration.millis(100));
    }

    public void manage_student_mouse_exited(MouseEvent mouseEvent) {
        TransitionUtil.start_scale_transition(1.0,1.0,manage_student_btn,Duration.millis(100));
    }

    public void manage_program_mouse_entered(MouseEvent mouseEvent) {
        TransitionUtil.start_scale_transition(1.2,1.2,manage_program_btn,Duration.millis(100));
    }

    public void manage_program_mouse_exited(MouseEvent mouseEvent) {
        TransitionUtil.start_scale_transition(1.0,1.0,manage_program_btn,Duration.millis(100));
    }


    public void manage_student_clicked(MouseEvent mouseEvent) throws IOException {
        main_menu_root.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ManageStudentForm.fxml"));
        Parent load = fxmlLoader.load();
        ManageStudentForm controller = fxmlLoader.getController();
        controller.setController(this);
        Scene scene = main_menu_root.getScene();

        load.translateXProperty().set(scene.getWidth());
        main_menu_root.getChildren().add(load);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(400),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void manage_program_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        main_menu_root.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ManageProgramForm.fxml"));
        Parent load = fxmlLoader.load();
        ManageProgramForm controller = fxmlLoader.getController();
        controller.setController(this);
        Scene scene = main_menu_root.getScene();
        load.translateXProperty().set(scene.getWidth());
        main_menu_root.getChildren().add(load);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(400),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void show_details_mouse_clicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ShowStudentAndProgramForm.fxml"))));
        stage.show();
    }
}
