import org.apache.commons.configuration.ConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class Command {
    RoomGUi gui;
    IconManager manager;
    Logic logic;
    Saving saving;
    public int count = 0;

    public Command(RoomGUi roomGUi, Logic logic) {
        gui = roomGUi;
        this.logic = logic;
        manager = new IconManager();
        try {
            saving = new Saving();
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    //Method for receiving input form the JTEXTFIELD as a String
    public void receiveInput(String inputCommand) {
        String[] splitInputCommand;
        inputCommand = inputCommand.toLowerCase();
        splitInputCommand = inputCommand.split(" ");
        if (this.logic.getActRoom().getGrantedDirections().contains(splitInputCommand[0]) || this.logic.getRiddleAnswers().contains(splitInputCommand[0])) {
            Room futureRoom = this.logic.nextRoom(this.logic.getActRoom(), inputCommand);
            if (this.logic.canAccess(futureRoom)) {
                this.logic.setPreviusRoom(this.logic.getActRoom());
                this.logic.setActRoom(futureRoom);
                gui.getTextField().setText("");
                changeRoom();
            } else {
                gui.getTextArea().setText("Non hai tutti gli tem necessari! Muoviti nelle altre stanze per cercarli.");
                gui.getTextField().setText("");
            }
        } else if (count == 0) {
            count++;
            System.out.println(inputCommand);
            this.logic.setMainCharacter(inputCommand);
            System.out.println("Il nome del tuo personaggio è: " + this.logic.getMainCharacter().getName());
            firstRoom();
            gui.getTextField().setText("");
        } else if (this.logic.getOtherCommands().contains(splitInputCommand[0])) {
            plusCommand(splitInputCommand);
            gui.getTextField().setText("");
        } else {
            gui.getTextArea().setText("Comando non riconosciuto!");
            gui.getTextField().setText("");
        }

    }

    private void firstRoom() {
        String s = logic.getMainCharacter().getName();
        System.out.println(s);
        gui.getTextArea().setText(s + logic.getRoomByIndex(0).getDescription() + "\n" + this.logic.showItem());
        ImageIcon icon = new ImageIcon(manager.iconArray[0].image);
        System.out.println(manager.iconArray[0].image);
        JLabel iconLabel = new JLabel(icon);
        gui.getImagePanel().removeAll();
        gui.getImagePanel().add(iconLabel);
        gui.getImagePanel().repaint();
    }

    public void printBackPack() {

    }

    public void changeRoom() {
        //Mi serve un metodo per ottonere la stanza giusta SIMONE dopo dimmi se ce l'hai già
        int actIndex = this.logic.getRoomIndex();
        //Metopo per modificare TextArea
        gui.getTextArea().setText(logic.findDescription() + "\n" + this.logic.showItem());

        //Creating the image and adding to the panel for replacing the old one
        ImageIcon icon = new ImageIcon(manager.iconArray[actIndex].image);
        System.out.println(manager.iconArray[0].image);
        JLabel iconLabel = new JLabel(icon);
        gui.getImagePanel().removeAll();
        gui.getImagePanel().add(iconLabel);
        gui.getImagePanel().repaint();


    }

    public void plusCommand(String[] command) {
        if (command[0].equals("help")) {
            helpFunction();
        } else if (command[0].equals("take")) {
            int choice = Integer.parseInt(command[1]);
            takeFunction(choice);
            return;
        } else if (command[0].equals("release")) {
            int choice = Integer.parseInt(command[1]);
            //releaseFunction(choice);
            return;
        } else if (command[0].equals("now")) {
            nowFunction();
        } else if (command[0].equals("backpack")) {
            backpackViewer();
        } else if (command[0].equals("save")) {
            try {
                save();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (command[0].equals("download")) {
            try {
                download();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Commando non riconosciuto");
        }
    }


    public void helpFunction() {
        String s = ("Questi sono tutti i comandi che puoi usare:\n" +
                "1) Comandi direzionali [nord, sud, est, ovest] --> ti permettono di spostarti all'interno dellla mappa\n" +
                "2) Comando [back] --> ti permette di tornare alla stanza precedente\n" +
                "3) Comando [take <item>] --> ti permette di mettere nel tuo zaino un item che trovi nelle varie stanze\n" +
                "4) Comando [release <item>] --> ti permette di togliere dallo zaino un item\n" +
                "5) Comando [backpack] --> ti permette di visualizzare quello che c'è nello zaino\n" +
                "6) Comando [now] --> indica la stanza in cui attualemnte ci troviamo\n");
        gui.getTextArea().setText(s);
    }

    public void backpackViewer() {
        String s = ("Nel tuo zaino hai: \n");
        for (int i = 0; i < this.logic.getMainCharacter().getBackpack().size(); i++) {
            s += (i + ")" + this.logic.getMainCharacter().getBackpack().get(i) + "\n");
        }
        gui.getTextArea().setText(s);
    }

    private void takeFunction(int choice) {
        if (choice >= 0 && choice < this.logic.getActRoom().getObject().size()) {
            this.logic.getMainCharacter().addItem(this.logic.getActRoom().getObject().get(choice));
            gui.getTextArea().setText("Hai raccolto: " + this.logic.getActRoom().getObject().get(choice));
            this.logic.getActRoom().getObject().remove(choice);

        } else {
            System.out.println("coglione");
        }

    }

    public void nowFunction() {
        gui.getTextArea().setText("Ti trovi: " + this.logic.getActRoom().getName());
        gui.getTextField().setText("");
    }

    public boolean indovinelliTempio(String risposta, Room futureRoom) {
            gui.getTextField().setText("");
            gui.getTextArea().setText("Per poter accedere al Tempio Perduto devi risolvere l'indovinello!\n La mia vita può durare qualche ora, quello che produco mi divora. Sottile sono veloce, grossa sono lenta e il vento molto mi spaventa. Chi sono?");
            risposta = risposta.toLowerCase();
            while(!risposta.equals("candela") && !risposta.equals("la candela")){

            }
            gui.getTextArea().setText("Complimenti hai indovinato, puoi proseguire con la tua avventura!");
            gui.getTextField().setText("");
            return true;

    }
    public boolean save() throws ConfigurationException {
        createFile();
        saving.upload();
        return true;
    }
    private void download() throws ConfigurationException {
        saving.download();
    }

    public void createFile(){
        try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //creo l'elemento principale
            Element root = document.createElement("game");
            document.appendChild(root);
            //creo  l'elemento charatcher, figlio di "game"
            Element mainCharacter = document.createElement("mainCharacter");
            root.appendChild(mainCharacter);

            //elemento name, filio di "main character"
            Element nameCh = document.createElement("name");
            mainCharacter.appendChild(nameCh);
            nameCh.appendChild(document.createTextNode(logic.getMainCharacter().getName()));

            //elemento backpack, figlio di character, che a sua volta ha i figli item
            Element backpack = document.createElement("backpack");
            mainCharacter.appendChild(backpack);
            for(int i = 0; i < logic.getMainCharacter().getBackpack().size(); i++){
                Element item = document.createElement("item");
                backpack.appendChild(item);
                item.setAttribute("id", String.valueOf(i));
                item.appendChild(document.createTextNode(logic.getMainCharacter().getBackpack().get(i).toString()));
            }

            Element rooms = document.createElement("rooms");
            root.appendChild(rooms);

            for(int i = 0; i < logic.getGameRoom().length; i++){
                Element room = document.createElement("room");
                rooms.appendChild(room);
                room.setAttribute("id", String.valueOf(i));
                Element thereIsChar = document.createElement("thereIsCharacter");
                room.appendChild(thereIsChar);
                if(logic.getRoomByIndex(i).getThereIsCharacter()){
                    thereIsChar.appendChild(document.createTextNode("true"));
                }else{
                    thereIsChar.appendChild(document.createTextNode("false"));
                }

                Element needItem = document.createElement("needItem");
                room.appendChild(needItem);
                if(logic.getRoomByIndex(i).getNeededItems().size() != 0){
                    for (int j = 0; j < logic.getRoomByIndex(i).getNeededItems().size(); j++) {
                        Element need = document.createElement("need");
                        needItem.appendChild(need);
                        need.setAttribute("id", String.valueOf(j));
                        need.appendChild(document.createTextNode(logic.getRoomByIndex(i).getNeededItems().get(j).toString()));
                    }
                }

                Element object = document.createElement("object");
                room.appendChild(object);
                if(logic.getRoomByIndex(i).getObject().size() != 0){
                    for(int k = 0; k < logic.getRoomByIndex(i).getObject().size(); k++){
                        Element objItem = document.createElement("objItem");
                        object.appendChild(objItem);
                        objItem.setAttribute("id", String.valueOf(k));
                        object.appendChild(document.createTextNode(logic.getRoomByIndex(i).getObject().get(k).toString()));
                    }
                }

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src/upload.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("file salvato");

        }catch (ParserConfigurationException | TransformerException e){
            e.printStackTrace();
        }
    }

}
