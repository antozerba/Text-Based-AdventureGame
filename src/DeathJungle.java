import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class DeathJungle {

    public static void main(String[] args) throws IOException, FontFormatException {
        Game game = new Game();
        Scanner scan  = new Scanner(System.in);
        Game1 newGame = new Game1(initialMenu(scan));
    }

    private static int initialMenu(Scanner scan){
        int firstChoice;
        do {
            System.out.print("Ciao, benvenuto su Death-Jungle. Scegli una tra queste opzioni:\n" +
                    "1) --> Inziare nuova partita\n" +
                    "2) --> Carica una partita\n" +
                    "3) --> Esci dal gioco\n" +
                    "Digita il corrispettivo numero: ");
            firstChoice = scan.nextInt();
        }while(firstChoice > 3 || firstChoice < 1);
        return firstChoice;
    }
}
