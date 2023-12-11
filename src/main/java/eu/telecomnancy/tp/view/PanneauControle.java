package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.presenter.Presenter;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanneauControle extends VBox {
    public PanneauControle(Presenter presenter) {
        Button valider = new Button("Valider");
        valider.setOnAction(e -> {
            presenter.valider();
            presenter.effacer();
        });
        Button effacer = new Button("Effacer");
        effacer.setOnAction(e -> presenter.effacer());
        Button relancer = new Button("relancer");
        relancer.setOnAction(e -> presenter.relancer());
        Button quitter = new Button("Quitter");
        quitter.setOnAction(e -> Platform.exit());
        getChildren().addAll(valider, effacer, relancer, quitter);
    }
}
