import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static int height;
    public static int width;
    public GamePanel() {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true); // permettono input informati
        requestFocus(true); //

    }
}
