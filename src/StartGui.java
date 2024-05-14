import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class StartGui extends JFrame{
    private Font titleFont;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JButton startBotton;
    private JPanel bottonPanel;

    public StartGui(Game.StartHandler startHandler) throws HeadlessException, IOException, FontFormatException {
        //FONT
        InputStream inputStream = getClass().getResourceAsStream("PressStart2P-Regular.ttf");
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

        //HENDLER
        //hendler = new ScreenHandler();

        //TITLE
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("DEATH-JUNGLE");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(titleFont);
        /*InputStream in = getClass().getResourceAsStream("/res/PressStart2P-Regular.ttf");
        font = Font.createFont(Font.TRUETYPE_FONT, in);
        titleLabel.setFont(font);*/

        /*//CenteringTitle
        Box box = new Box(BoxLayout.Y_AXIS);
        box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(Box.createVerticalGlue());
        box.add(titlePanel);
        box.add(Box.createVerticalGlue());*/

        //BOTTON
        startBotton = new JButton("Start");
        startBotton.setBackground(Color.BLACK);
        startBotton.setPreferredSize(new Dimension(120,80));
        startBotton.addActionListener(startHandler);
        bottonPanel = new JPanel();
        bottonPanel.setBounds(300,300,200,200);
        bottonPanel.setBackground(Color.BLACK);



        titlePanel.add(titleLabel);
        bottonPanel.add(startBotton);
        add(titlePanel);
        add(bottonPanel);
        setVisible(true);
    }
}
