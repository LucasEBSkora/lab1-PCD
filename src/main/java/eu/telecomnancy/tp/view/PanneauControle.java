package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.model.Boggle;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanneauControle extends VBox {
    public PanneauControle(Boggle model) {
        Button valider = new Button("Valider");
        valider.setOnAction(e -> model.valider());
        Button effacer = new Button("Effacer");
        effacer.setOnAction(e -> model.effacer());
        Button quitter = new Button("Quitter");
        quitter.setOnAction(e -> Platform.exit());
        getChildren().addAll(valider, effacer, quitter);
    }
}
