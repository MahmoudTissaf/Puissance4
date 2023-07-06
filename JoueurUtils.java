import java.util.Scanner;

public class JoueurUtils {

    public static int getChoixJoueur(Scanner scanner) {
        System.out.print("Entrez un numéro de colonne (0-6) : ");
        return scanner.nextInt();
    }
}
