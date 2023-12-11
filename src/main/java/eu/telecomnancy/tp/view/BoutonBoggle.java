package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.model.Boggle;
import javafx.scene.control.Button;

public class BoutonBoggle extends Button {
    final int ligne;
    final int colomne;

    final Boggle model;

    public BoutonBoggle(int ligne, int colomne, Boggle model) {
        this.ligne = ligne;
        this.colomne = colomne;
        this.model = model;
        miseAJourTexte();
        setOnAction(e -> this.model.ajouterLettre(this.ligne, this.colomne));
        model.ajouterEcouterRelance(this::miseAJourTexte);
    }

    public void miseAJourTexte() {
        this.setText(String.valueOf(model.getLettre(this.ligne, this.colomne)));
    }
}
