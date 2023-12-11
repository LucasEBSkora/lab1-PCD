package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.presenter.Presenter;
import javafx.scene.layout.GridPane;

public class VueLettres extends GridPane {
    BoutonBoggle[][] boutons;

    public VueLettres(Presenter presenter, int taille) {
        boutons = new BoutonBoggle[taille][taille];
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colomne = 0; colomne < taille; colomne++) {
                boutons[ligne][colomne] = new BoutonBoggle(ligne, colomne, presenter);
                GridPane.setConstraints(boutons[ligne][colomne], ligne, colomne);
                getChildren().add(boutons[ligne][colomne]);
            }
        }
    }
}
