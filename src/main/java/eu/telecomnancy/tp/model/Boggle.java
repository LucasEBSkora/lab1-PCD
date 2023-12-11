package eu.telecomnancy.tp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Boggle {

    private static final char[] voyelles = {'A', 'E', 'I', 'O', 'U', 'Y'};
    private static final char[] consonnes = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'};
    private final List<Consumer<Integer>> ecouterScore;
    private final List<Consumer<String>> ecouterMotCourant;

    private final List<Runnable> ecouterRelance;
    private final char[][] lettres;
    private StringBuilder mot;
    private int score = 0;
    private int ligneChoisie, colonneChoisie;  // dernière case choisie

    private final int taille;

    /**
     * Des voyelles sur les lignes impaires ; des consonnes sur les lignes paires
     *
     * @param taille taille du tableau de jeu
     * @throws AssertionError taille <= 1
     */
    public Boggle(int taille) {
        assert (taille > 1) : "Trop petit";
        this.taille = taille;
        this.lettres = new char[taille][taille];
        this.ecouterScore = new ArrayList<>();
        this.ecouterMotCourant = new ArrayList<>();
        this.ecouterRelance = new ArrayList<>();
        relancer();
    }

    public void relancer() {
        Random gen = new Random();
        for (int lig = 0; lig < taille; lig++)
            if (lig % 2 == 0)
                for (int col = 0; col < taille; col++)
                    lettres[lig][col] = voyelles[gen.nextInt(6)];
            else
                for (int col = 0; col < taille; col++)
                    lettres[lig][col] = consonnes[gen.nextInt(20)];

        this.mot = new StringBuilder();
        this.ligneChoisie = -1;
        this.colonneChoisie = -1;
        this.score = 0;
        notifierEcouterRelance();
    }

    /**
     * @return taille du jeu (carré)
     */
    public int size() {
        return this.lettres.length;
    }

    /**
     * @param l ligne de la case
     * @param c colomne de la case
     * @return lettre de la case spécifiée
     * @throws AssertionError l < 0 || l >= size()
     * @throws AssertionError c < 0 || c >= size()
     */
    public char getLettre(int l, int c) {
        assert (l >= 0 && l < this.size()) : "Ligne incorrecte";
        assert (c >= 0 && c < this.size()) : "colonne incorrecte";
        return this.lettres[l][c];
    }

    /**
     * @return mot en cours de construction
     */
    public String getMotChoisi() {
        return this.mot.toString();
    }

    /**
     * @param l1 ligne de la case 1
     * @param c1 colomne de la case 1
     * @param l2 ligne de la case 2
     * @param c2 colomne de la case 2
     * @return vrai si les cases sont contigües
     * @throws AssertionError l1 < 0 || l1 >= size()
     * @throws AssertionError c1 < 0 || c1 >= size()
     * @throws AssertionError l2 < 0 || l2 >= size()
     * @throws AssertionError c2 < 0 || c2 >= size()
     */
    private boolean casesContigues(int l1, int c1, int l2, int c2) {
        assert (l1 >= 0 && l1 < this.size()) : "Ligne incorrecte";
        assert (c1 >= 0 && c1 < this.size()) : "colonne incorrecte";
        assert (l2 >= 0 && l2 < this.size()) : "Ligne incorrecte";
        assert (c2 >= 0 && c2 < this.size()) : "colonne incorrecte";
        int diffL = Math.abs(l1 - l2);
        int diffC = Math.abs(c1 - c2);
        return !((diffL == 0) && (diffC == 0)) && diffL <= 1 && diffC <= 1;
    }

    /**
     * Valider le mot en cours de construction
     * s'il est dans le dictionnaire, le score est incrémenté du nombre de lettres
     * sinon, le score est décrémenté de 1.
     */
    public void valider() {

        Dictionnaire dico = Dictionnaire.getInstance();
        if (dico.contient(mot.toString()))
            this.score += this.mot.length();
        else
            this.score -= 1;
        this.mot = new StringBuilder();
        this.ligneChoisie = -1;
        this.colonneChoisie = -1;
        notifierEcouterScore();
    }

    private void notifierEcouterScore() {
        for (Consumer<Integer> e : ecouterScore) {
            e.accept(this.score);
        }
    }

    private void notifierEcouterRelance() {
        for (Runnable e : ecouterRelance) {
            e.run();
        }
    }


    /**
     * Effacer le mot en cours de construction
     */
    public void effacer() {
        this.mot = new StringBuilder();
        this.ligneChoisie = -1;
        this.colonneChoisie = -1;
        notifierEcoutersMotCourant();
    }

    private void notifierEcoutersMotCourant() {
        for (Consumer<String> e : ecouterMotCourant) {
            e.accept(this.getMotChoisi());
        }
    }


    /**
     * La lettre en case lig, col a été choisie
     * On conserve la lettre si la case est contigüe à la précédente
     *
     * @param lig ligne choisie
     * @param col colomne choisie
     */
    public void ajouterLettre(int lig, int col) {
        if (this.ligneChoisie == -1 || casesContigues(this.ligneChoisie, this.colonneChoisie, lig, col)) {
            this.mot.append(this.getLettre(lig, col));
            this.ligneChoisie = lig;
            this.colonneChoisie = col;
            notifierEcoutersMotCourant();
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
}
