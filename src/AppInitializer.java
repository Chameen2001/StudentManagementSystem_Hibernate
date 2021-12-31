import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/HomePage.fxml"));
        Parent load = fxmlLoader.load();
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.setTitle("IJSE");
        primaryStage.show();
        /*primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/HomePage.fxml"))));
        primaryStage.show();*/

    }
}
