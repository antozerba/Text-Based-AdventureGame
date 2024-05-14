import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Command {
    RoomGUi gui;
    IconManager manager;
    ArrayList<Room> roomAntoArrayList;

    public Command(RoomGUi roomGUi, ArrayList<Room> roomAntos) {
        gui = roomGUi;
        roomAntoArrayList = roomAntos;
        manager = new IconManager();
    }

    //Method for receiving input form the JTEXTFIELD as a String
    public void receiveInput(String inputCommand){

        if(inputCommand.equals(">ok")){
            System.out.println(inputCommand);
            changeRoom();
        }
    }
    public void printBackPack(){

    }
    public void changeRoom(){
        //Mi serve un metodo per ottonere la stanza giusta SIMONE dopo dimmi se ce l'hai già

        //Metopo per modificare TextArea
        gui.getTextArea().setText(roomAntoArrayList.get(0).getDescription());

        //Creating the image and adding to the panel for replacing the old one
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
