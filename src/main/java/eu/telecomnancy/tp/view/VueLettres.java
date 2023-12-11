package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.model.Boggle;
import javafx.scene.layout.GridPane;

public class VueLettres extends GridPane {
    BoutonBoggle[][] boutons;

    public VueLettres(Boggle model, int taille) {
        boutons = new BoutonBoggle[taille][taille];
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colomne = 0; colomne < taille; colomne++) {
                boutons[ligne][colomne] = new BoutonBoggle(ligne, colomne, model);
                GridPane.setConstraints(boutons[ligne][colomne], ligne, colomne);
                getChildren().add(boutons[ligne][colomne]);
            }
        }
    }
}
