import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Command {
    RoomGUi gui;
    IconManager manager;
    ArrayList<Room> roomArrayList;

    public Command(RoomGUi roomGUi, ArrayList<Room> rooms) {
        gui = roomGUi;
        roomArrayList = rooms;
        manager = new IconManager();
    }


    public void receiveInput(String inputCommand){

        if(inputCommand.equals(">ok")){
            System.out.println(inputCommand);
            changeRoom();
        }
    }
    public void printBackPack(){

    }
    public void changeRoom(){
        //Mi serve un metodo per ottonere la stanza giusta

        //Metopo per modificare TextArea
        gui.getTextArea().setText(roomArrayList.get(0).getDescription());

        //Creo l'immagine e poi ne facccio una label per inserirla nela pannello
        ImageIcon icon = new ImageIcon(manager.iconArray[0].image);
        System.out.println(manager.iconArray[0].image);
        JLabel iconLabel = new JLabel(icon);
        System.out.println(iconLabel);
        System.out.println(Arrays.toString(manager.iconArray));
        gui.getImagePanel().removeAll();
        gui.getImagePanel().add(iconLabel);
        gui.getImagePanel().repaint();


    }

}
