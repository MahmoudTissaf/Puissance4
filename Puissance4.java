import java.util.Scanner;

public class Puissance4 {

    public static void main(String[] args) {
        final int LIGNES = 6;
        final int COLONNES = 7;
        final String VIDE = ".";
        final String JOUEUR_X = "X";
        final String JOUEUR_O = "O";

        String[][] plateau = new String[LIGNES][COLONNES];
        PlateauUtils.initialiserPlateau(plateau, VIDE);

        boolean finPartie = false;
        String joueurCourant = JOUEUR_X;

        Scanner scanner = new Scanner(System.in);

        while (!finPartie) {
            PlateauUtils.afficherPlateau(plateau);

            int colonne = JoueurUtils.getChoixJoueur(scanner);

            if (!PlateauUtils.estCoupValide(plateau, colonne)) {
                System.out.println("Coup invalide. Veuillez réessayer.");
                continue;
            }

            PlateauUtils.jouerCoup(plateau, joueurCourant, colonne);

            if (PlateauUtils.estCoupGagnant(plateau, joueurCourant)) {
                PlateauUtils.afficherPlateau(plateau);
                System.out.println("Le joueur " + joueurCourant + " a gagné !");
                finPartie = true;
            } else if (PlateauUtils.estPlateauPlein(plateau)) {
                PlateauUtils.afficherPlateau(plateau);
                System.out.println("Match nul !");
                finPartie = true;
            }

            joueurCourant = (joueurCourant.equals(JOUEUR_X)) ? JOUEUR_O : JOUEUR_X;
        }

        scanner.close();
    }
}
