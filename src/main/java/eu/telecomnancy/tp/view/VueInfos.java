package eu.telecomnancy.tp.view;

import eu.telecomnancy.tp.model.Boggle;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class VueInfos extends TilePane {

    final Label motCourant;
    final Label score;

    public VueInfos(Boggle boggle) {

        motCourant = new Label();
        miseAjourMotCourant("");
        score = new Label();
        miseAJourScore(0);
        getChildren().addAll(motCourant, score);

        boggle.ajouterEcouterScore(this::miseAJourScore);
        boggle.ajouterEcouterMot(this::miseAjourMotCourant);
    }

    void miseAJourScore(Integer s) {
        score.setText("Score: " + s);
    }

    void miseAjourMotCourant(String mot) {
        motCourant.setText("Mot Choisi: " + mot);
    }
}
