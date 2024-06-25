import javax.swing.*;

public class Command {
    RoomGUi gui;
    IconManager manager;
    Logic logic;
    public int count =0;

    public Command(RoomGUi roomGUi, Logic logic) {
        gui = roomGUi;
        this.logic = logic;
        manager = new IconManager();
    }

    //Method for receiving input form the JTEXTFIELD as a String
    public void receiveInput(String inputCommand){
        String[] splitInputCommand;
        inputCommand = inputCommand.toLowerCase();
        splitInputCommand = inputCommand.split(" ");
        if(this.logic.getActRoom().getGrantedDirections().contains(splitInputCommand[0]) || this.logic.getRiddleAnswers().contains(splitInputCommand[0])) {
            Room futureRoom = this.logic.nextRoom(this.logic.getActRoom(), inputCommand);
             /*if(futureRoom.equals(this.logic.getRoomByIndex(6))){
                if(indovinelliTempio(inputCommand, futureRoom)){
                    this.logic.setPreviusRoom(this.logic.getActRoom());
                    this.logic.setActRoom(futureRoom);
                    gui.getTextField().setText("");
                    changeRoom();
                }
            }else*/ if(this.logic.canAccess(futureRoom)){
                this.logic.setPreviusRoom(this.logic.getActRoom());
                this.logic.setActRoom(futureRoom);
                gui.getTextField().setText("");
                changeRoom();
            }
        }else if(count == 0){
            count++;
            System.out.println(inputCommand);
            this.logic.setMainCharacter(inputCommand);
            System.out.println("Il nome del tuo personaggio è: " + this.logic.getMainCharacter().getName());
            firstRoom();
            gui.getTextField().setText("");
        }else if(this.logic.getOtherCommands().contains(splitInputCommand[0])){
            plusCommand(splitInputCommand);
            gui.getTextField().setText("");
        }else {
            gui.getTextArea().setText("Comando non riconosciuto!");
            gui.getTextField().setText("");
        }
        /*gameRun.nextRoom(gameRun.getActRoom(), inputCommand);

        if(inputCommand.equals(">Simone")){
            System.out.println(inputCommand);
            this.gameRun.setMainCharacter(inputCommand);
            System.out.println("Il nome del tuo personaggio è: " + this.gameRun.getMainCharacter().getName());

            //changeRoom();
        }*/

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

    public void printBackPack(){

    }
    public void changeRoom(){
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

    public void plusCommand(String[] command){
        if(command[0].equals("help")){
            helpFunction();
        }else if(command[0].equals("take")){
            int choice = Integer.parseInt(command[1]);
            takeFunction(choice);
            return;
        }else if(command[0].equals("release")){
            int choice = Integer.parseInt(command[1]);
            //releaseFunction(choice);
            return;
        }else if(command[0].equals("now")){
            nowFunction();
        }else if(command[0].equals("backpack")){
            backpackViewer();
        }else if(command[0].equals("save")) {
            save();
        }else{
            System.out.println("Commando non riconosciuto");
        }
    }

    public void helpFunction(){
        String s = ("Questi sono tutti i comandi che puoi usare:\n" +
                "1) Comandi direzionali [nord, sud, est, ovest] --> ti permettono di spostarti all'interno dellla mappa\n" +
                "2) Comando [back] --> ti permette di tornare alla stanza precedente\n" +
                "3) Comando [take <item>] --> ti permette di mettere nel tuo zaino un item che trovi nelle varie stanze\n" +
                "4) Comando [release <item>] --> ti permette di togliere dallo zaino un item\n" +
                "5) Comando [backpack] --> ti permette di visualizzare quello che c'è nello zaino\n" +
                "6) Comando [now] --> indica la stanza in cui attualemnte ci troviamo\n");
        gui.getTextArea().setText(s);
    }

    public void backpackViewer(){
        String s = ("Nel tuo zaino hai: \n");
        for(int i = 0; i < this.logic.getMainCharacter().getBackpack().size(); i++){
            s += (i + ")" + this.logic.getMainCharacter().getBackpack().get(i) + "\n");
        }
        gui.getTextArea().setText(s);
    }

    private void takeFunction(int choice){
        if(choice >= 0 && choice < this.logic.getActRoom().getObject().size()){
            this.logic.getMainCharacter().addItem(this.logic.getActRoom().getObject().get(choice));
            gui.getTextArea().setText("Hai raccolto: " + this.logic.getActRoom().getObject().get(choice));
            this.logic.getActRoom().getObject().remove(choice);

        }else{
            System.out.println("coglione");
        }

    }

    public void nowFunction(){
        gui.getTextArea().setText("Ti trovi: " + this.logic.getActRoom().getName());
        gui.getTextField().setText("");
    }

    public boolean indovinelliTempio(String risposta, Room futureRoom){
        gui.getTextField().setText("");
        gui.getTextArea().setText("Per poter accedere al Tempio Perduto devi risolvere l'indovinello!\n La mia vita può durare qualche ora, quello che produco mi divora. Sottile sono veloce, grossa sono lenta e il vento molto mi spaventa. Chi sono?");
        risposta = risposta.toLowerCase();
        if((risposta.equals("candela") || risposta.equals("la candela")) && this.logic.canAccess(futureRoom)){
            gui.getTextArea().setText("Complimenti hai indovinato, puoi proseguire con la tua avventura!");
            gui.getTextField().setText("");
            return true;
        }else{
            return false;
        }
    }
    public boolean save(){
        return true;
    }

}