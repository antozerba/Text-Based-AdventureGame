import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class VisabilityManager implements KeyListener {
    Command command;
    RoomGUi gui;
    ArrayList<Room> roomList;

    public VisabilityManager(RoomGUi gui, ArrayList<Room> roomList) {
        this.command = new Command(gui,roomList);
        this.gui = gui;
        this.roomList = roomList;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("Ciao");
            command.receiveInput(gui.getTextField().getText());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
