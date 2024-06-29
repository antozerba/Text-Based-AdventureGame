import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//classe principale del gioco

public class Logic {
    //attributi di Game
    private Scanner scan;
    private int gameID;
    private Character mainCharacter;
    private Room actRoom;
    private Room previusRoom;
    private Room[] gameRoom;
    private Directions directions;
    private final ArrayList<String> otherCommands = new ArrayList<String>(Arrays.asList("take", "release", "help", "backpack", "now", "save", "download"));

    private final ArrayList<String> riddleAnswers = new ArrayList<String>(Arrays.asList("candela", "la candela"));

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setMainCharacter(Character mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public Room getActRoom() {
        return actRoom;
    }

    public void setActRoom(Room actRoom) {
        this.actRoom = actRoom;
    }

    public Room getPreviusRoom() {
        return previusRoom;
    }

    public void setPreviusRoom(Room previusRoom) {
        this.previusRoom = previusRoom;
    }

    public Room[] getGameRoom() {
        return gameRoom;
    }

    public void setGameRoom(Room[] gameRoom) {
        this.gameRoom = gameRoom;
    }

    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }

    public ArrayList<String> getOtherCommands() {
        return otherCommands;
    }

    public Logic(){
        this.gameRoom = null;
        this.actRoom = null;
        this.mainCharacter = new Character();
        this.previusRoom = null;
        this.scan = new Scanner(System.in);
        this.directions = new Directions();
    }

    public ArrayList<String> getRiddleAnswers() {
        return riddleAnswers;
    }

    public void createRoom(){
        this.gameRoom = new Room[14];
        String[] roomName = {"Giugla", "Stanza Pluviale", "Boscaglia", "Sentiero dei Serpenti", "Tempio Perduto", "Camera dei Riti Sacri", "Sala dell'Altare Antico", "Anticamera", "Stanza delle Reliquie Celesti", "Covo delle Anime Perdute", "Stanza degli Enigmi", "Antro dell'Oscurità", "Corridoio dei Destini Intrecciati", "Stanza del Tesoro"};
        for(int i = 0; i < gameRoom.length; i++){
            gameRoom[i] = new Room(roomName[i]);
            //System.out.println(gameRoom[i].getName());
        }
        /*gameRoom[0].setThereIsCharacter(true);
        this.actRoom = gameRoom[0];*/
        System.out.println(findDescription());

    }

    public void actualGameRoom(){
        for(int i = 0; i < this.gameRoom.length; i++){
            if(gameRoom[i].getThereIsCharacter()){
                System.out.println("Ora ti trovi nella stanza: " + this.gameRoom[i].getName());
            }
        }
    }

    //metodo che contiene tutte le descrizioni delle varie stanze e che grazie in base all'indice passato ritorna la giusta descrizione
    public String findDescription(){
        String[] descriptionRoom = {(" ti trovi disperso nel bel mezzo della giungla, il tuo scopo è quello di trovare il tempio e impossesarti del tesoro perduto."),
                ("Ti sei addentrato nella zona della giungla più oscura, la foresta pluviale, di tutte e sei finito in un vicolo cieco, ma  mai dire mai che magari qualcosa di utile lo puoi trovare... \n"),
                ("La tua avventura prosegue, ora ti trovi ancora nel bel mezzo della boscaglia, sei circondato da una folta vegetazione e da altissimi alberi. Prosegui con la tua avventura...\n"),
                ("Caspita, " + this.mainCharacter.getName() + " sei finito in una delle zone più pericolose della giungla, il sentiero dei Serpenti.\n" +
                        "L'unico modo per escirne vivo è quello di uccidere tutti i serpenti, spero tu abbia tutto il necessario per riuscirci."),
                ("Complimenti " + this.mainCharacter.getName() + " sei riuscito a trovare la strada per il Tempio Perduto. Ora però non è così facile entrarci, per fare ciò dovrai risolvere un indovinello per sbloccare \n" +
                        "la porta e poi avrai bisogno di due chiavi per aprirla..."),
                ("Sei entrato nella Camera dei Riti Sacri, anticamente usata per compiere rituali spirituali e religiosi.\n Prosegui con la tua avventura..."),
                ("Se sei arrivato fino a qui vuol dire che sei riuscito a risolvere l'enigma, ora non ti resta che trovare la stanza del Tesoro Perduto, buona fortuna!"),
                (this.mainCharacter.getName() + " ti trovi nell'Anticamera una zona misteriosa, prova a cercare che magari qualcosa di utile puoi trovare..."),
                ("La stanza delle Reliquie Celesti un tempo era collegato alla Camera dei Riti Sacri, ma a differenza di quella stanza in questa puoi trovare le reliquie dei vecchi Templari..."),
                ("In questa stanza si facevano riti per invocare le anime dei propri cari... magari qualcuno puoi trovare che qualche utile consiglio ti può dare.."),
                ("Sei arrivato nella Stanza degli Enigmi, qua se qualcosa di importante vuoi trovare alcune domande devi superare."),
                ("Se fin qui sei arrivato vuol dire che qualcosa di importante hai combinato, ma la tua avventura non è ancora conclusa, sei sempre più vicino a trovare il tesoro, ma aimè in un vicolo cieco sei finito.. l'unica è tornare indietro."),
                (this.mainCharacter.getName() + " sei quasi arrivato, per accedere alla fatidica stanza in direzione di dove sorge il sole devi proseguire.."),
                ("Complimenti " + this.mainCharacter.getName() + " sei arrivato nella stanza del Tesoro Perduto!")};

        //System.out.println("La lunghezza della descrizone è di: " + descriptionRoom.length);
        for(int i = 0; i < descriptionRoom.length; i++){
            this.gameRoom[i].setDescription(descriptionRoom[i]);
        }
        for(int j = 0; j < this.gameRoom.length; j++){
            if(this.gameRoom[j].getThereIsCharacter()){
                return this.gameRoom[j].getDescription();
            }
        }
        return "";
    }

    public void setRoom(){
        //prima stanza, giungla
        this.gameRoom[0].setObject(new ArrayList<Item>(){{add(Item.Torcia);}});
        this.gameRoom[0].setGrantedDirections(directions.getNB());

        //seconda stanza, stanza pluviale
        this.gameRoom[1].setObject(new ArrayList<Item>() {{add(Item.ChiaveDellAvventuriero);}});
        this.gameRoom[1].setGrantedDirections(directions.getEB());

        //terza stanza, boscaglia
        this.gameRoom[2].setObject(new ArrayList<Item>(){{add(Item.Macete);}});
        this.gameRoom[2].setGrantedDirections(directions.getNESOB());

        //quarta stanza, sentiero dei serpenti
        this.gameRoom[3].setNeededItems(new ArrayList<Item>(){{add(Item.Macete);}});
        this.gameRoom[3].setObject(new ArrayList<Item>(){{add(Item.ChiaveDellaSerpeSmeraldo);}});
        this.gameRoom[3].setGrantedDirections(directions.getOB());

        //quinta stanza, Tempio perduto
        //this.gameRoom[4].setNeededItems(new ArrayList<Item>(){{add(Item.Macete);}});
        this.gameRoom[4].setGrantedDirections(directions.getNSB());

        //sesta stanza, Camera dei Riti Sacri
        this.gameRoom[5].setGrantedDirections(directions.getNEB());

        //settima stanza, Sala dell'Altare Antico
        this.gameRoom[6].setNeededItems(new ArrayList<Item>(){{add(Item.ChiaveDellAvventuriero); add(Item.ChiaveDellaSerpeSmeraldo);}});
        this.gameRoom[6].setGrantedDirections(directions.getESOB());

        //ottava stanza, Anticamera
        this.gameRoom[7].setObject(new ArrayList<Item>(){{add(Item.PergamenaDelleProfezieAntiche);}});
        this.gameRoom[7].setGrantedDirections(directions.getOB());


        //nona stanza, Stanza dell Reliquie Celesti
        this.gameRoom[8].setObject(new ArrayList<Item>(){{add(Item.CaliceDelSangueAntico);}});
        this.gameRoom[8].setGrantedDirections(directions.getNESB());

        //decima stanza, Covo delle Anime Perdute
        this.gameRoom[9].setObject(new ArrayList<Item>(){{add(Item.LanternaDellEternaPenombra);}});
        this.gameRoom[9].setGrantedDirections(directions.getNEOB());

        //undicesima stanza, Stanza degli Enigmi
        this.gameRoom[10].setNeededItems(new ArrayList<Item>(){{add(Item.PergamenaDelleProfezieAntiche);}});
        this.gameRoom[10].setGrantedDirections(directions.getOB());
        this.gameRoom[10].setObject(new ArrayList<Item>(){{add(Item.ChiaveDelTesoroAntico);}});

        //dodicesima stanza, Antro dell'Oscurità
        this.gameRoom[11].setNeededItems(new ArrayList<Item>(){{add(Item.LanternaDellEternaPenombra);}});
        this.gameRoom[11].setGrantedDirections(directions.getSB());

        //tredicesima stanza, Corridoio dei Destini Intrecciati
        this.gameRoom[12].setGrantedDirections(directions.getESB());

        //quattordicesima stanza, Stanza del Tesoro
        this.gameRoom[13].setNeededItems(new ArrayList<Item>(){{add(Item.ChiaveDelTesoroAntico); /*add(Item.CaliceDelSangueAntico);*/ }});
        this.gameRoom[13].setObject(new ArrayList<Item>(){{add(Item.TesoroAntico);}});
        this.gameRoom[13].setGrantedDirections(directions.getNOB());
    }
    //sono in una stanza, metto un comando tra quelli possibili, se è una direzione mi sposto di stanza, altrimenti mi comporto di conseguenza
    public void gameLoop(){
        String command;
        String[] splitCommand;
        while(!this.gameRoom[13].getThereIsCharacter() && this.actRoom != this.gameRoom[13]){
            //showItem();
            System.out.print("\nInserisci il prossimo comando per proseguire: ");
            do {
                command = this.scan.nextLine();
                command = command.toLowerCase();
                splitCommand = command.split(" ");
                if(actRoom.getGrantedDirections().contains(splitCommand[0])) {
                    //scelgo qual è la stanza futura
                    Room futureRoom = nextRoom(this.actRoom, command);
                    if(canAccess(futureRoom)){  //controllo se ci posso entrare
                        //System.out.println("Qua ci arrivo?");
                        this.previusRoom = this.actRoom;
                        //this.previusRoom.setThereIsCharacter(false);
                        this.actRoom = futureRoom;
                        //System.out.print(findDescription());
                        showItem();
                        //this.actRoom.setThereIsCharacter(true);
                    }else{
                        System.out.print("\nNon hai tutti gli Item necessari per entrare nella stanza!");
                    }
                }
            }while(!actRoom.getGrantedDirections().contains(command));
        }
    }

    public boolean canAccess(Room nextRoom){
        //passo tutti gli elementi che il mainCharacter contiene nello zaino
        for(int i = 0; i < this.mainCharacter.getBackpack().size(); i++){
            //confronto gli item con i needed item della stanza, se combaciano li rimuovo sia da una parte che dall'altra
            if(nextRoom.getNeededItems().contains(this.mainCharacter.getBackpack().get(i)) ) {
                nextRoom.getNeededItems().remove(this.mainCharacter.getBackpack().get(i));
                this.mainCharacter.getBackpack().remove(i);
            }
            //eseguo questo ciclo fino a che l'ArrayList neededItem non è vuoto
        }
        //se è vuoto allora posso entrare, altrimenti no
        if(nextRoom.getNeededItems().isEmpty()){
            System.out.println("Hai tutti gli Item");
            return true;
        }else{
            System.out.println("Non hai tutti gli item neccesari per entrare in questa stanza!");
            return false;
        }
    }

    public Room nextRoom(Room actualRoom, String command){
        if(actualRoom == this.gameRoom[0]){
            this.gameRoom[0].setThereIsCharacter(false);
            if(command.equals("nord")){
                this.gameRoom[2].setThereIsCharacter(true);
                return this.gameRoom[2];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }
            else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[1]){
            this.gameRoom[1].setThereIsCharacter(false);
            if(command.equals("est")){
                this.gameRoom[2].setThereIsCharacter(true);
                return this.gameRoom[2];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[2]){
            this.gameRoom[2].setThereIsCharacter(false);
            if(command.equals("nord")){
                this.gameRoom[4].setThereIsCharacter(true);
                return this.gameRoom[4];
            }else if(command.equals("est")){
                System.out.println("Grazie al macete sei risucito a sconfiggere il Serpente Smeraldo, complimenti! \nEcco a te il premio...\n");
                this.gameRoom[3].setThereIsCharacter(true);
                return this.gameRoom[3];
            }else if (command.equals("sud")){
                this.gameRoom[0].setThereIsCharacter(true);
                return this.gameRoom[0];
            }else if(command.equals("ovest")){
                this.gameRoom[1].setThereIsCharacter(true);
                return this.gameRoom[1];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[3]){
            this.gameRoom[3].setThereIsCharacter(false);
            if(command.equals("ovest")){
                this.gameRoom[2].setThereIsCharacter(true);
                return this.gameRoom[2];
            }else if(command.equals( "back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
            //siamo nel tempio perduto
        }else if(actualRoom == this.gameRoom[4]){
            this.gameRoom[4].setThereIsCharacter(false);
            if(command.equals("nord")){
                this.gameRoom[6].setThereIsCharacter(true);
                return this.gameRoom[6];
            }else if (command.equals("sud")){
                this.gameRoom[2].setThereIsCharacter(true);
                return this.gameRoom[2];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[5]){
            this.gameRoom[5].setThereIsCharacter(false);
            if(command.equals("nord")){
                this.gameRoom[8].setThereIsCharacter(true);
                return this.gameRoom[8];
            }else if(command.equals("est")){
                this.gameRoom[6].setThereIsCharacter(true);
                return this.gameRoom[6];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[6]){
            this.gameRoom[6].setThereIsCharacter(false);
            if(command.equals("est")){
                this.gameRoom[7].setThereIsCharacter(true);
                return this.gameRoom[7];
            }else if (command.equals("sud")){
                this.gameRoom[4].setThereIsCharacter(true);
                return this.gameRoom[4];
            }else if(command.equals("ovest")){
                this.gameRoom[5].setThereIsCharacter(true);
                return this.gameRoom[5];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[7]){
            this.gameRoom[7].setThereIsCharacter(false);
            if(command .equals("ovest")){
                this.gameRoom[6].setThereIsCharacter(true);
                return this.gameRoom[6];
            }else if(command.equals("back")){
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[8]){
            this.gameRoom[8].setThereIsCharacter(false);
            if(command.equals("nord")){
                this.gameRoom[11].setThereIsCharacter(true);
                return this.gameRoom[11];
            }else if(command.equals("est")){
                this.gameRoom[9].setThereIsCharacter(true);
                return this.gameRoom[9];
            }else if (command.equals("sud")){
                this.gameRoom[5].setThereIsCharacter(true);
                return this.gameRoom[5];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[9]){
            this.gameRoom[9].setThereIsCharacter(false);
            if(command.equals("nord")){
                this.gameRoom[12].setThereIsCharacter(true);
                return this.gameRoom[12];
            }else if(command.equals("est")){
                this.gameRoom[10].setThereIsCharacter(true);
                return this.gameRoom[10];
            }else if (command.equals("ovest")){
                this.gameRoom[8].setThereIsCharacter(true);
                return this.gameRoom[8];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[10]){
            this.gameRoom[10].setThereIsCharacter(false);
            if(command.equals("ovest")){
                this.gameRoom[9].setThereIsCharacter(true);
                return this.gameRoom[9];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[11]){
            this.gameRoom[11].setThereIsCharacter(false);
            if(command.equals("sud")){
                this.gameRoom[8].setThereIsCharacter(true);
                return this.gameRoom[8];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[12]){
            this.gameRoom[12].setThereIsCharacter(false);
            if(command.equals("est")){
                this.gameRoom[13].setThereIsCharacter(true);
                return this.gameRoom[13];
            }else if (command.equals("sud")){
                this.gameRoom[9].setThereIsCharacter(true);
                return this.gameRoom[9];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else if(actualRoom == this.gameRoom[13]){
            this.gameRoom[13].setThereIsCharacter(false);
            if(command.equals("ovest")){
                this.gameRoom[12].setThereIsCharacter(true);
                return this.gameRoom[12];
            }else if(command.equals("back")){
                this.previusRoom.setThereIsCharacter(true);
                return this.previusRoom;
            }else{
                return actualRoom;
            }
        }else{
            return actualRoom;
        }
    }

    public String showItem(){
        String s = ("\nGli Item presenti in questa stanza sono: \n");
        for(int i = 0; i < this.actRoom.getObject().size(); i++){
            s += (i + ") " + this.actRoom.getObject().get(i).toString() + "\n");
        }
        return s;
    }

    public void releaseFunction(int choice){
        if(choice >= 0 && choice < this.mainCharacter.getBackpack().size()){
            this.actRoom.addItem(this.mainCharacter.getBackpack().get(choice));
            this.mainCharacter.getBackpack().remove(choice);
            System.out.print("Oggetto rimosso, continua con il gioco: ");
        }else{
            System.out.print("\nVolore non valido! \nContinua con il gioco: ");
        }
    }

    public void setMainCharacter(String name){
        this.mainCharacter.setName(name);
    }

    public Character getMainCharacter(){
        return this.mainCharacter;
    }
    public int getRoomIndex(){
        for(int i=0; i<this.gameRoom.length; i++){
            if(gameRoom[i].getThereIsCharacter())
                return i;
        }
        return -1;
    }

    public Room getRoomByIndex(int index){
        return this.gameRoom[index];
    }

    public void data(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        }

        // Carica il documento XML
        org.w3c.dom.Document doc = null;
        try {
            doc = builder.parse("src/download.xml");
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        // Normalizza il documento XML
        ((org.w3c.dom.Document) doc).getDocumentElement().normalize();

        // Ottieni l'elemento radice
        Element root = ((org.w3c.dom.Document) doc).getDocumentElement();



        //Processa l'elemento mainCharacter
        Node mainCharacter = doc.getElementsByTagName("mainCharacter").item(0);
        if (mainCharacter.getNodeType() == Node.ELEMENT_NODE) {
            Element mainCharacterElement = (Element) mainCharacter;
            String name = mainCharacterElement.getElementsByTagName("name").item(0).getTextContent();
            this.mainCharacter.setName(name);

            NodeList backpackItems = mainCharacterElement.getElementsByTagName("item");
            ArrayList<Item> backpack = new ArrayList<Item>();
            for (int i = 0; i < backpackItems.getLength(); i++) {
                Element item = (Element) backpackItems.item(i);
                backpack.add(Item.valueOf(item.getTextContent().replace(" ", "")));
            }
            this.mainCharacter.setBackpack(backpack);
        }

        // Processa gli elementi rooms
       NodeList rooms = doc.getElementsByTagName("room");
        for (int i = 0; i < rooms.getLength(); i++) {
            Node room = rooms.item(i);
            if (room.getNodeType() == Node.ELEMENT_NODE) {
                Element roomElement = (Element) room;
                String roomId = roomElement.getAttribute("id");
                String thereIsCharacter = roomElement.getElementsByTagName("thereIsCharacter").item(0).getTextContent();
                this.getRoomByIndex(i).setThereIsCharacter(Boolean.valueOf(thereIsCharacter));
                if(getRoomByIndex(i).getThereIsCharacter())
                    setActRoom(getRoomByIndex(i));

                NodeList needs = roomElement.getElementsByTagName("need");
                ArrayList<Item> needItem = new ArrayList<Item>();
                for (int j = 0; j < needs.getLength(); j++) {
                    Element need = (Element) needs.item(j);
                    needItem.add(Item.valueOf(need.getTextContent().replace(" ", "")));
                }

                this.getRoomByIndex(i).setNeededItems(needItem);

                NodeList objects = roomElement.getElementsByTagName("object");
                ArrayList<Item> objectItem = new ArrayList<Item>();
                for (int k = 0; k < objects.getLength(); k++) {
                    Element object = (Element) objects.item(k);

                    String objItemId = object.getElementsByTagName("objItem").getLength() > 0 ?
                            object.getElementsByTagName("objItem").item(0).getTextContent() : "";
                    String objText = object.getTextContent().trim();
                    if (!objItemId.isEmpty() || !objText.isEmpty()) {
                        objectItem.add(Item.valueOf(objText.replace(" ", "")));
                    }
                }
                this.getRoomByIndex(i).setObject(objectItem);
            }
        }
    }
}