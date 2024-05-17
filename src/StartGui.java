import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class StartGui extends JFrame{
    private Font titleFont;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JButton startButton;
    private JButton uploadButton;
    private JPanel bottonPanel;


    public StartGui() throws HeadlessException, IOException, FontFormatException {

        //FONT
        InputStream inputStream = getClass().getResourceAsStream("font/PressStart2P-Regular.ttf");
        try {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(45f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //WINDOW
        setSize(800,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        //TITLE
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("DEATH-JUNGLE");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(titleFont);


     /*   //CenteringTitle
        Box box = new Box(BoxLayout.Y_AXIS);
        box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(Box.createVerticalGlue());
        box.add(titlePanel);
        box.add(Box.createVerticalGlue());*/

        //STARTYBOTTON
        startButton = new JButton("Start");
        startButton.setBackground(Color.BLACK);
        startButton.setFont(new Font("Arial", Font.PLAIN, 23));
        startButton.setPreferredSize(new Dimension(120,80));
        bottonPanel = new JPanel();
        bottonPanel.setBounds(250,250,300,200);
        bottonPanel.setBackground(Color.BLACK);


        //UPLOADBOTTON
        uploadButton = new JButton("Upload");
        uploadButton.setBackground(Color.BLACK);
        uploadButton.setFont(new Font("Arial", Font.PLAIN, 23));
        uploadButton.setPreferredSize(new Dimension(120,80));


        //ADDING COMPONENT TO FRAME
        titlePanel.add(titleLabel);
        bottonPanel.add(startButton);
        bottonPanel.add(uploadButton);
        add(titlePanel);
        add(bottonPanel);
        setVisible(true);
    }
    public void setStartHandler(Game.StartHandler hendler){
        startButton.addActionListener(hendler);
    }
    public void setUploadHendler(Game.UploadHendler hendler){
        uploadButton.addActionListener(hendler);
    }
}
