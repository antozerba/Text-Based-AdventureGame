import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Game {

    public static Font titleFont;
    private  ArrayList<Room> roomList;
    private StartGui startGui;
    private RoomGUi gui;
    private StartHandler startHandler;
    private VisabilityManager manager;




    public Game() throws IOException, FontFormatException {
        startHandler = new StartHandler();
        startGui = new StartGui(startHandler);

        roomList = new ArrayList<>();
        roomList.add(new Room("Savana"));
        roomList.add(new Room("Deserto"));


    }
    public void startGame(){
    }
    class StartHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gui = new RoomGUi();
            manager = new VisabilityManager(gui, roomList);
            gui.setManager(manager);
            startGui.setVisible(false);
        }
    }


}
