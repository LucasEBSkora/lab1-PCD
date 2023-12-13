package eu.telecomnancy.tp.presenter;

import eu.telecomnancy.tp.model.Boggle;
import eu.telecomnancy.tp.view.BoutonBoggle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Presenter {
    public final List<Consumer<Integer>> ecouterScore;
    public final List<Consumer<String>> ecouterMotCourant;

    public final List<Runnable> ecouterRelance;

    public final List<Runnable> ecouterMotFini;

    public final Boggle model;

    public Presenter(Boggle model) {
        this.ecouterScore = new ArrayList<>();
        this.ecouterMotCourant = new ArrayList<>();
        this.ecouterRelance = new ArrayList<>();
        ecouterMotFini = new ArrayList<>();
        this.model = model;
        this.model.setPresenter(this);

    }

    public void notifierEcouterScore(int score) {
        for (Consumer<Integer> e : ecouterScore) {
            e.accept(score);
        }
    }

    public void notifierEcouterRelance() {
        for (Runnable e : ecouterRelance) {
            e.run();
        }
    }

    public void notifierEcouterMotFini() {
        for (Runnable e : ecouterMotFini) {
            e.run();
        }
    }


    public void notifierEcoutersMotCourant(String mot) {
        for (Consumer<String> e : ecouterMotCourant) {
            e.accept(mot);
        }
    }

    public void ajouterEcouterScore(Consumer<Integer> o) {
        ecouterScore.add(o);
    }

    public void ajouterEcouterMot(Consumer<String> o) {
        ecouterMotCourant.add(o);
    }


    public void ajouterEcouterRelance(Runnable o) {
        ecouterRelance.add(o);
    }

    public void ajouterEcouterMotFini(Runnable o) {
        ecouterMotFini.add(o);
    }

    public boolean ajouterLettreDuBouton(BoutonBoggle boutonBoggle) {
        return model.ajouterLettre(boutonBoggle.ligne, boutonBoggle.colomne);
    }

    public char getLettre(BoutonBoggle boutonBoggle) {
        return this.model.getLettre(boutonBoggle.ligne, boutonBoggle.colomne);
    }

    public void valider() {
        this.model.valider();
    }

    public void effacer() {
        this.model.effacer();
    }

    public void relancer() {
        this.model.relancer();
    }


}
