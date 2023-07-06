public class PlateauUtils {

    public static void initialiserPlateau(String[][] plateau, String symboleVide) {
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = symboleVide;
            }
        }
    }

    public static void afficherPlateau(String[][] plateau) {
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
        System.out.println();
    }

    public static boolean estCoupValide(String[][] plateau, int colonne) {
        final int COLONNES = plateau[0].length;
        return colonne >= 0 && colonne < COLONNES && plateau[0][colonne].equals(".");
    }

    public static void jouerCoup(String[][] plateau, String joueur, int colonne) {
        for (int ligne = plateau.length - 1; ligne >= 0; ligne--) {
            if (plateau[ligne][colonne].equals(".")) {
                plateau[ligne][colonne] = joueur;
                break;
            }
        }
    }

    public static boolean estCoupGagnant(String[][] plateau, String joueur) {
        // Vérification horizontale
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            for (int colonne = 0; colonne <= plateau[ligne].length - 4; colonne++) {
                if (plateau[ligne][colonne].equals(joueur) &&
                        plateau[ligne][colonne + 1].equals(joueur) &&
                        plateau[ligne][colonne + 2].equals(joueur) &&
                        plateau[ligne][colonne + 3].equals(joueur)) {
                    return true;
                }
            }
        }

        // Vérification verticale
        for (int ligne = 0; ligne <= plateau.length - 4; ligne++) {
            for (int colonne = 0; colonne < plateau[ligne].length; colonne++) {
                if (plateau[ligne][colonne].equals(joueur) &&
                        plateau[ligne + 1][colonne].equals(joueur) &&
                        plateau[ligne + 2][colonne].equals(joueur) &&
                        plateau[ligne + 3][colonne].equals(joueur)) {
                    return true;
                }
            }
        }

        // Vérification diagonale (haut-gauche vers bas-droite)
        for (int ligne = 0; ligne <= plateau.length - 4; ligne++) {
            for (int colonne = 0; colonne <= plateau[ligne].length - 4; colonne++) {
                if (plateau[ligne][colonne].equals(joueur) &&
                        plateau[ligne + 1][colonne + 1].equals(joueur) &&
                        plateau[ligne + 2][colonne + 2].equals(joueur) &&
                        plateau[ligne + 3][colonne + 3].equals(joueur)) {
                    return true;
                }
            }
        }

        // Vérification diagonale (bas-gauche vers haut-droite)
        for (int ligne = plateau.length - 1; ligne >= 3; ligne--) {
            for (int colonne = 0; colonne <= plateau[ligne].length - 4; colonne++) {
                if (plateau[ligne][colonne].equals(joueur) &&
                        plateau[ligne - 1][colonne + 1].equals(joueur) &&
                        plateau[ligne - 2][colonne + 2].equals(joueur) &&
                        plateau[ligne - 3][colonne + 3].equals(joueur)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean estPlateauPlein(String[][] plateau) {
        for (String[] ligne : plateau) {
            for (String cellule : ligne) {
                if (cellule.equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }
}
