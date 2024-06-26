/**
 * Classe iniziale dell'avvio del gioco con la creazione dei vari componenti necessari
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game {

    public static Font titleFont;
    private StartGui startGui;
    private RoomGUI gui;
    private StartHandler startHandler;
    private UploadHendler uploadHendler;
    private VisibilityManager manager;
    private Logic logic;


    /**
     * Costruttore
     * @throws IOException
     * @throws FontFormatException
     */
    public Game() throws IOException, FontFormatException {
        startHandler = new StartHandler();
        uploadHendler = new UploadHendler();
        startGui = new StartGui();
        startGui.setStartHandler(startHandler);
        startGui.setUploadHendler(uploadHendler);
    }

    public RoomGUI getGui() {
        return gui;
    }
    public static Font getTitleFont() {
        return titleFont;
    }

    public static void setTitleFont(Font titleFont) {
        Game.titleFont = titleFont;
    }

    public StartGui getStartGui() {
        return startGui;
    }

    public void setStartGui(StartGui startGui) {
        this.startGui = startGui;
    }

    public void setGui(RoomGUI gui) {
        this.gui = gui;
    }

    public StartHandler getStartHandler() {
        return startHandler;
    }

    public void setStartHandler(StartHandler startHandler) {
        this.startHandler = startHandler;
    }

    public UploadHendler getUploadHendler() {
        return uploadHendler;
    }

    public void setUploadHendler(UploadHendler uploadHendler) {
        this.uploadHendler = uploadHendler;
    }

    public VisibilityManager getManager() {
        return manager;
    }

    public void setManager(VisibilityManager manager) {
        this.manager = manager;
    }

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }


    /**
     * Classe interna che gestisce il bottone Start
     */
    class StartHandler implements ActionListener{

        /**
         * Override del metodo dell'interfaccia ActionLister che gestisce gli eventi collegati al bottone
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //Creating window for the room access
            gui = new RoomGUI();
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

    /**
     * Classe interna che gestisce il bottone Upload
     */
    class UploadHendler implements ActionListener{

        /**
         * Override del metodo dell'interfaccia ActionLister che gestisce gli eventi collegati al bottone
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            gui = new RoomGUI();
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
