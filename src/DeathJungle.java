import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DeathJungle {

    public static void main(String[] args) throws IOException, FontFormatException {
        deleteFile();
        Game game = new Game();
        Scanner scan  = new Scanner(System.in);
        //Game1 newGame = new Game1(initialMenu(scan));
    }

    public static void deleteFile() {
        File upload = new File("src/upload.xml");
        File download = new File("src/download.xml");

        // Check if the file exists
        if (upload.exists()) {
            // Try to delete the file
            if (upload.delete()) {
                System.out.println("File deleted successfully upload file");
            } else {
                System.out.println("Failed to delete the file upload file");
            }
        } else {
            System.out.println("File not found");
        }

        if (download.exists()) {
            // Try to delete the file
            if (download.delete()) {
                System.out.println("File deleted successfully download file");
            } else {
                System.out.println("Failed to delete the file download file");
            }
        } else {
            System.out.println("File not found");
        }
    }
}
