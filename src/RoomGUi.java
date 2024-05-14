import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class RoomGUi extends JFrame {
    private JPanel imagePanel;
    private JPanel textPanel;
    private JTextArea textArea;
    private JTextField textField;
    private VisabilityManager  manager;
    private Font gamefont;

    ImageIcon image;
    Font font = new Font("Verdana", Font.BOLD, 12);

    public RoomGUi() throws HeadlessException {


        //Font
        InputStream in = getClass().getResourceAsStream("PressStart2P-Regular.ttf");
        try {
            gamefont = Font.createFont(Font.TRUETYPE_FONT, in).deriveFont(12f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Icon
        image = new ImageIcon("jungle.png");

        //Frame
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);


        //Spazio Immagine
        imagePanel = new JPanel();
        imagePanel.setBounds(0,0,800, 275);
        imagePanel.setBackground(Color.BLACK);
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/jungle.png"));
            System.out.println(ImageIO.read(new File("src/jungle.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        imagePanel.add(picLabel);


        //Spazio Messaggio
        textPanel = new JPanel();
        textPanel.setBounds(50,300, 700,300);
        textPanel.setBackground(Color.BLACK);
        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.green);
        textArea.setFont(gamefont);
        textArea.setText("Benvenuti nella giungla, dove ogni passo è una sfida e ogni mistero nasconde un'avventura senza fine. Preparati a scoprire i segreti nascosti tra le fronde e a sfidare le creature selvagge che popolano questo regno inesplorato.");
        textArea.setBounds(0, 200, 700, 200);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);


        //Input Commnad
        textField = new JTextField(">");
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.green);
        textField.setFont(gamefont);
        textField.setPreferredSize(new Dimension(700,20));
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

    public JPanel getImagePanel() {
        return imagePanel;
    }

    public JPanel getTextPanel() {
        return textPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setManager(VisabilityManager manager) {
        this.manager = manager;
        textField.addKeyListener(manager);

    }
}
