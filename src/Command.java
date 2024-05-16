import javax.swing.*;

public class Command {
    RoomGUi gui;
    IconManager manager;
    Game1 gameRun;
    public Command(RoomGUi roomGUi, Game1 gameRun) {
        gui = roomGUi;
        this.gameRun = gameRun;
        manager = new IconManager();
    }

    //Method for receiving input form the JTEXTFIELD as a String
    public void receiveInput(String inputCommand){
        String[] splitInputCommand;
        inputCommand = inputCommand.toLowerCase();
        splitInputCommand = inputCommand.split(" ");
        if(this.gameRun.getActRoom().getGrantedDirections().contains(splitInputCommand[0])){
            Room futureRoom = this.gameRun.nextRoom(this.gameRun.getActRoom(), inputCommand);
            if(this.gameRun.canAccess(futureRoom)){
                this.gameRun.setPreviusRoom(this.gameRun.getActRoom());
                this.gameRun.setActRoom(futureRoom);
                gui.getTextField().setText("");
                changeRoom();
            }
        }else if(inputCommand.equals(">simone")){
            System.out.println(inputCommand);
            this.gameRun.setMainCharacter(inputCommand);
            System.out.println("Il nome del tuo personaggio è: " + this.gameRun.getMainCharacter().getName());
            firstRoom();
            gui.getTextField().setText("");
        }else if(this.gameRun.getOtherCommands().contains(splitInputCommand[0])){
            plusCommand(splitInputCommand);
            gui.getTextField().setText("");
        }else {
            System.out.println("Non ti puoi muovere in questa direzione! \nInserisci nuovamente il camando per proseguire: ");
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
        gui.getTextArea().setText(gameRun.getRoomByIndex(0).getDescription() + "\n" + this.gameRun.showItem());
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
        int actIndex = this.gameRun.getRoomIndex();
        //Metopo per modificare TextArea
        gui.getTextArea().setText(gameRun.findDescription() + "\n" + this.gameRun.showItem());

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
            //nowFunction();
        }else if(command[0].equals("backpack")){
            backpackViewer();
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
        for(int i = 0; i < this.gameRun.getMainCharacter().getBackpack().size(); i++){
            s += (i + ")" + this.gameRun.getMainCharacter().getBackpack().get(i) + "\n");
        }
        gui.getTextArea().setText(s);
    }

    private void takeFunction(int choice){
        if(choice >= 0 && choice < this.gameRun.getActRoom().getObject().size()){
            this.gameRun.getMainCharacter().addItem(this.gameRun.getActRoom().getObject().get(choice));
            gui.getTextArea().setText("Hai raccolto: " + this.gameRun.getActRoom().getObject().get(choice));
            this.gameRun.getActRoom().getObject().remove(choice);

        }else{
            System.out.println("coglione");
        }

    }

}
