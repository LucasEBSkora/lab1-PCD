package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.presenter.Presenter;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class VueLettres extends GridPane {
    BoutonBoggle[][] boutons;

    public VueLettres(Presenter presenter, int taille) {
        boutons = new BoutonBoggle[taille][taille];
        setPadding(new Insets(10));
        setVgap(2);
        setHgap(2);
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colomne = 0; colomne < taille; colomne++) {
                BoutonBoggle nouveauBouton = new BoutonBoggle(ligne, colomne, presenter);
                GridPane.setHgrow(nouveauBouton, Priority.ALWAYS);
                GridPane.setVgrow(nouveauBouton, Priority.ALWAYS);
                GridPane.setConstraints(nouveauBouton, ligne, colomne);
                getChildren().add(nouveauBouton);
            }
        }
    }
}
