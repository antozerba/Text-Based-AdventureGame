import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class VisibilityManager implements KeyListener {
    Command command;
    RoomGUi gui;
    ArrayList<Room> roomAntoList;

    public VisibilityManager(RoomGUi gui, ArrayList<Room> roomAntoList) {
        this.command = new Command(gui, roomAntoList);
        this.gui = gui;
        this.roomAntoList = roomAntoList;
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
