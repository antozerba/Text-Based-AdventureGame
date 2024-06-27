import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VisibilityManager implements KeyListener {
    Command command;
    RoomGUi gui;
    Logic logic;

    public VisibilityManager(RoomGUi gui, Logic logic) {
        this.command = new Command(gui, logic);
        this.gui = gui;
        //this.roomAntoList = roomAntoList;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            command.receiveInput(gui.getTextField().getText());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Command getCommand() {
        return command;
    }
}
