import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game {

    public static Font titleFont;
    //private  ArrayList<Room> gameRoom;
    private StartGui startGui;
    private RoomGUi gui;
    private StartHandler startHandler;
    private UploadHendler uploadHendler;
    private VisibilityManager manager;
    private Logic logic;

    //simone
    //private Scanner scan;
    //private int gameID;
    /*private Character mainCharacter;
    private Room actRoom;
    private Room previusRoom;
    //private Room[] gameRoom;
    private Directions directions;
    private final ArrayList<String> otherCommands = new ArrayList<String>(Arrays.asList("take", "release", "help", "backpack", "now"));
*/



    public Game() throws IOException, FontFormatException {
        startHandler = new StartHandler();
        uploadHendler = new UploadHendler();
        startGui = new StartGui();
        startGui.setStartHandler(startHandler);
        startGui.setUploadHendler(uploadHendler);
        //createRoom();
        //gameRoom = new ArrayList<>();
        //gameRoom.add(new Room("Savana"));
        //gameRoom.add(new Room("Deserto"));


    }
    public void startGame(){
    }
    class StartHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Creating window for the room access
            gui = new RoomGUi();
            logic = new Logic();
            logic.createRoom();
            logic.setRoom();
            logic.getRoomByIndex(0).setThereIsCharacter(true);
            logic.setActRoom(logic.getRoomByIndex(0));
            manager = new VisibilityManager(gui, logic);
            gui.setManager(manager);
            manager.getCommand().setCount(0);
            startGui.setVisible(false);

        }
    }
    class UploadHendler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gui = new RoomGUi();
            logic = new Logic();
            logic.createRoom();
            logic.setRoom();
            manager = new VisibilityManager(gui, logic);
            gui.setManager(manager);
            manager.getCommand().saving.download();
            logic.data();
            manager.getCommand().setCount(1);
            manager.getCommand().changeRoom();
            startGui.setVisible(false);
        }
    }

}
