package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.presenter.Presenter;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class VueInfos extends TilePane {

    final Label motCourant;
    final Label score;

    public VueInfos(Presenter presenter) {

        motCourant = new Label();
        miseAjourMotCourant("");
        score = new Label();
        miseAJourScore(0);
        getChildren().addAll(motCourant, score);

        presenter.ajouterEcouterScore(this::miseAJourScore);
        presenter.ajouterEcouterMot(this::miseAjourMotCourant);
    }

    void miseAJourScore(Integer s) {
        score.setText("Score: " + s);
    }

    void miseAjourMotCourant(String mot) {
        motCourant.setText("Mot Choisi: " + mot);
    }
}
