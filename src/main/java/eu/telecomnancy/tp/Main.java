package eu.telecomnancy.tp;

import eu.telecomnancy.tp.model.Boggle;
import eu.telecomnancy.tp.presenter.Presenter;
import eu.telecomnancy.tp.view.MenuBoggle;
import eu.telecomnancy.tp.view.PanneauControle;
import eu.telecomnancy.tp.view.VueInfos;
import eu.telecomnancy.tp.view.VueLettres;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Boggle model = new Boggle(7);
        Presenter presenter = new Presenter(model);
        VueInfos vueInfos = new VueInfos(presenter);
        root.setBottom(vueInfos);
        VueLettres vueLettres = new VueLettres(presenter, 7);
        root.setCenter(vueLettres);
        PanneauControle panneauControle = new PanneauControle(presenter);
        root.setRight(panneauControle);
        MenuBoggle menu = new MenuBoggle();
        root.setTop(menu);
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Boggle");
        stage.setScene(scene);
        stage.show();
    }
}