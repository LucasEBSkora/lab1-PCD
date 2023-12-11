package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.model.Boggle;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanneauControle extends VBox {
    public PanneauControle(Boggle model) {
        Button valider = new Button("Valider");
        valider.setOnAction(e -> {model.valider(); model.effacer();});
        Button effacer = new Button("Effacer");
        effacer.setOnAction(e -> model.effacer());
        Button relancer = new Button("relancer");
        relancer.setOnAction(e -> model.relancer());
        Button quitter = new Button("Quitter");
        quitter.setOnAction(e -> Platform.exit());
        getChildren().addAll(valider, effacer, relancer, quitter);
    }
}
