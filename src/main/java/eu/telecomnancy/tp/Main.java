package eu.telecomnancy.tp;

import eu.telecomnancy.tp.model.Boggle;
import eu.telecomnancy.tp.view.MenuBoggle;
import eu.telecomnancy.tp.view.PanneauControle;
import eu.telecomnancy.tp.view.VueInfos;
import eu.telecomnancy.tp.view.VueLettres;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Boggle model = new Boggle(7);
        VueInfos vueInfos = new VueInfos(model);
        root.setBottom(vueInfos);
        VueLettres vueLettres = new VueLettres(model, 7);
        root.setCenter(vueLettres);
        PanneauControle panneauControle = new PanneauControle(model);
        root.setRight(panneauControle);
        MenuBoggle menu = new MenuBoggle();
        root.setTop(menu);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Boggle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}