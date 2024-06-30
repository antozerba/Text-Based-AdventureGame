/**
 * Classe che implementa l'interfaccia grafica della varie stanze
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class RoomGUI extends JFrame {
    private JPanel imagePanel;
    private JPanel textPanel;
    private JTextArea textArea;
    private JTextField textField;
    private VisibilityManager  manager;
    private Font gamefont;

   private ImageIcon image;

    /**
     * Costruttore
     * @throws HeadlessException
     */
    public RoomGUI() throws HeadlessException {


        /**
         * FONT
         */
        InputStream in = getClass().getResourceAsStream("font/PressStart2P-Regular.ttf");
        try {
            gamefont = Font.createFont(Font.TRUETYPE_FONT, in).deriveFont(12f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         * FRAME-WINDOW
         */
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);


        /**
         * SPAZIO IMMAGINE
         */
        imagePanel = new JPanel();
        imagePanel.setBounds(0,10,800, 275);
        imagePanel.setBackground(Color.BLACK);
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/images/tes.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        imagePanel.add(picLabel);


        /**
         * SPAZIO MESSAGGIO DI TESTO
         */
        textPanel = new JPanel();
        textPanel.setBounds(50,300, 700,300);
        textPanel.setBackground(Color.BLACK);
        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.green);
        textArea.setFont(gamefont);
        textArea.setText("Ciao avventuriero inserisci il nome del tuo personagqgio: ");
        textArea.setBounds(0, 200, 700, 200);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);


        /**
         * BLOCCO INPUT DI TESTO
         */
        textField = new JTextField("");
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.green);
        textField.setFont(gamefont);
        textField.setPreferredSize(new Dimension(700,20));
        Border border = LineBorder.createBlackLineBorder();
        Border coloredBorder = new LineBorder(Color.GREEN, 1);
        textField.setBorder(coloredBorder);

        JLabel inputLabel = new JLabel("Inserisci comando:");
        inputLabel.setForeground(Color.green);
        inputLabel.setPreferredSize(new Dimension(300, 40));
        inputLabel.setFont(gamefont);


        textPanel.add(textArea);
        textPanel.add(inputLabel);
        textPanel.add(textField);

        add(imagePanel);
        add(textPanel);
        setVisible(true);
    }

    /**
     * Getter
     * @return
     */
    public JPanel getImagePanel() {
        return imagePanel;
    }

    /**
     * Getter
     * @return
     */
    public JPanel getTextPanel() {
        return textPanel;
    }

    /**
     * Getter
     * @return
     */
    public JTextArea getTextArea() {
        return textArea;
    }

    /**
     * Getter
     * @return
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * Assegna manager a TextField
     * @param manager
     */
    public void setManager(VisibilityManager manager) {
        this.manager = manager;
        textField.addKeyListener(manager);

    }
}
