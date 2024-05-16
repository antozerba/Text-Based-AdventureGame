import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VisibilityManager implements KeyListener {
    Command command;
    RoomGUi gui;
    Game1 gameRun;

    public VisibilityManager(RoomGUi gui, Game1 gameRun) {
        this.command = new Command(gui, gameRun);
        this.gui = gui;
        //this.roomAntoList = roomAntoList;
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
