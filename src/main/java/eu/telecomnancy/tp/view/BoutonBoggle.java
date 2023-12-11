package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.presenter.Presenter;
import javafx.scene.control.Button;

public class BoutonBoggle extends Button {
    public final int ligne;
    public final int colomne;

    final Presenter presenter;

    public BoutonBoggle(int ligne, int colomne, Presenter presenter) {
        this.ligne = ligne;
        this.colomne = colomne;
        this.presenter = presenter;
        miseAJourTexte();
        setOnAction(e -> this.presenter.ajouterLettreDuBouton(this));
        presenter.ajouterEcouterRelance(this::miseAJourTexte);
    }

    public void miseAJourTexte() {
        this.setText(String.valueOf(presenter.getLettre(this)));
    }
}
