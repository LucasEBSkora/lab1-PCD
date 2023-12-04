package eu.telecomnancy.labfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    int timesButtonClicked;
    int timesCombination421;

    @Override
    public void start(Stage primaryStage) {
        timesButtonClicked = 0;
        timesCombination421 = 0;

        primaryStage.setTitle("TP0");
        boolean[] selecione = new boolean[3];
        selecione[0] = selecione[1] = selecione[2] = false;

        Button button = new Button("Jouer");
        Button b1 = new Button();
        b1.setOnAction(e -> selecione[0] = !selecione[0]);
        b1.setGraphic(new ImageView(Objects.requireNonNull(getClass().getResource("/eu/telecomnancy/labfx/images/Dice-1-b.svg.png")).toExternalForm()));

        Button b2 = new Button();
        b2.setOnAction(e -> selecione[1] = !selecione[1]);

        b2.setGraphic(new ImageView(Objects.requireNonNull(getClass().getResource("/eu/telecomnancy/labfx/images/Dice-1-b.svg.png")).toExternalForm()));

        Button b3 = new Button();
        b3.setOnAction(e -> selecione[2] = !selecione[2]);
        b3.setGraphic(new ImageView(Objects.requireNonNull(getClass().getResource("/eu/telecomnancy/labfx/images/Dice-1-b.svg.png")).toExternalForm()));

        Label coupsJoues = new Label("coups joués: 0");
        Label resultats = new Label("nb combination 421: 0");

        int[] des = new int[3];

        button.setOnAction(e -> {
            boolean[] trouve = new boolean[3];
            for (int i = 0; i < 3; ++i) {
                if (selecione[i]) {
                    des[i] = 1 + ThreadLocalRandom.current().nextInt(5);
                }
                switch (des[i]) {
                    case 1:
                        trouve[0] = true;
                        break;
                    case 2:
                        trouve[1] = true;
                        break;
                    case 4:
                        trouve[2] = true;
                        break;
                }
            }
            coupsJoues.setText("coups joués: " + ++timesButtonClicked);
            b1.setGraphic(new ImageView(Objects.requireNonNull(getClass().getResource("/eu/telecomnancy/labfx/images/Dice-" + (des[0]) + "-b.svg.png")).toExternalForm()));
            b2.setGraphic(new ImageView(Objects.requireNonNull(getClass().getResource("/eu/telecomnancy/labfx/images/Dice-" + (des[1]) + "-b.svg.png")).toExternalForm()));
            b3.setGraphic(new ImageView(Objects.requireNonNull(getClass().getResource("/eu/telecomnancy/labfx/images/Dice-" + (des[2]) + "-b.svg.png")).toExternalForm()));
            if (trouve[0] && trouve[1] && trouve[2]) {
                resultats.setText("nb combination 421: " + ++timesCombination421);
            }
        });

        AnchorPane anchor = new AnchorPane();
        AnchorPane.setBottomAnchor(button, 0.);
        AnchorPane.setLeftAnchor(button, 0.);

        anchor.getChildren().add(button);

        HBox hboxCenter = new HBox();
        hboxCenter.getChildren().addAll(b1, b2, b3);
        BorderPane pane = new BorderPane(hboxCenter);
        anchor.getChildren().add(pane);

        BorderPane topPane = new BorderPane();
        topPane.setLeft(coupsJoues);
        topPane.setRight(resultats);
        pane.setTop(topPane);

        ImageView imageView = new ImageView(Objects.requireNonNull(getClass().getResource("/eu/telecomnancy/labfx/images/kawai.png")).toExternalForm());
        Button exitButton = new Button();
        exitButton.setGraphic(imageView);
        exitButton.setOnAction(e -> Platform.exit());

        pane.setLeft(exitButton);


        Scene scene = new Scene(anchor, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
