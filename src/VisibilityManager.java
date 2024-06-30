/**
 * Classe addetta alla gestione della comunicazione tra interfaccia grafica e utente
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VisibilityManager implements KeyListener {
    Command command;
    RoomGUI gui;
    Logic logic;

    public VisibilityManager(RoomGUI gui, Logic logic) {
        this.command = new Command(gui, logic);
        this.gui = gui;
        //this.roomAntoList = roomAntoList;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Overrride del metodo dell'interfeccia che mi permette di gestire gli input da tastiera
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            command.receiveInput(gui.getTextField().getText());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Getter di command
     * @return
     */
    public Command getCommand() {
        return command;
    }
}
