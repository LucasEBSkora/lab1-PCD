package eu.telecomnancy.labfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.application.Platform;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    int timesButtonClicked;

    @Override
    public void start(Stage primaryStage) throws IOException {
        timesButtonClicked = 0;

        primaryStage.setTitle("TP0");

        Button button = new Button("Jouer");
        button.setOnAction(e -> {
            System.out.println("Hello! times button clicked: " + timesButtonClicked++);
        });

        AnchorPane anchor = new AnchorPane();
        AnchorPane.setBottomAnchor(button, 0.);
        AnchorPane.setLeftAnchor(button, 0.);

        anchor.getChildren().add(button);

        Scene scene = new Scene(anchor, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
