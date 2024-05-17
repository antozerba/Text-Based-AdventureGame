import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game {

    public static Font titleFont;
    //private  ArrayList<Room> gameRoom;
    private StartGui startGui;
    private RoomGUi gui;
    private StartHandler startHandler;
    private UploadHendler uploadHendler;
    private VisibilityManager manager;
    private Logic logic;

    //simone
    //private Scanner scan;
    //private int gameID;
    /*private Character mainCharacter;
    private Room actRoom;
    private Room previusRoom;
    //private Room[] gameRoom;
    private Directions directions;
    private final ArrayList<String> otherCommands = new ArrayList<String>(Arrays.asList("take", "release", "help", "backpack", "now"));
*/



    public Game() throws IOException, FontFormatException {
        startHandler = new StartHandler();
        uploadHendler = new UploadHendler();
        startGui = new StartGui();
        startGui.setStartHandler(startHandler);
        startGui.setUploadHendler(uploadHendler);
        //createRoom();
        //gameRoom = new ArrayList<>();
        //gameRoom.add(new Room("Savana"));
        //gameRoom.add(new Room("Deserto"));


    }
    public void startGame(){
    }
    class StartHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Creating window for the room access
            gui = new RoomGUi();
            logic = new Logic();
            logic.createRoom();
            logic.setRoom();
            //gameRun.setRoom();
            manager = new VisibilityManager(gui, logic);
            gui.setManager(manager);
            startGui.setVisible(false);

        }
    }
    class UploadHendler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /*private void createRoom(){
        this.gameRoom = new ArrayList<Room>();
        String[] roomName = {"Giugla", "Stanza Pluviale", "Boscaglia", "Sentiero dei Serpenti", "Tempio Perduto", "Camera dei Riti Sacri", "Sala dell'Altare Antico", "Anticamera", "Stanza delle Reliquie Celesti", "Covo delle Anime Perdute", "Stanza degli Enigmi", "Antro dell'Oscurità", "Corridoio dei Destini Intrecciati", "Stanza del Tesoro"};
        for(int i = 0; i < roomName.length; i++){
            gameRoom.add(new Room(roomName[i]));
        }

        this.gameRoom.get(0).setThereIsCharacter(true);
        this.actRoom = this.gameRoom.get(0);
        System.out.println(findDescription());
        setRoom();
        showItem();
        gameLoop();
        //System.out.print(findDescription(mainCharacter));

    }

    private void setRoom(){
        //prima stanza, giungla
        this.gameRoom.get(0).setObject(new ArrayList<Item>(){{add(Item.Torcia);}});
        this.gameRoomget(0).setGrantedDirections(directions.getN());

        //seconda stanza, stanza pluviale
        this.gameRoom.get(1).setObject(new ArrayList<Item>() {{add(Item.ChiaveDellAvventuriero);}});
        this.gameRoom.get(1).setGrantedDirections(directions.getEB());

        //terza stanza, boscaglia
        this.gameRoom.get(2).setObject(new ArrayList<Item>(){{add(Item.Macete);}});
        this.gameRoom.get(2).getGrantedDirections(directions.getNESOB());

        //quarta stanza, sentiero dei serpenti
        this.gameRoom.get(3).setNeededItems(new ArrayList<Item>(){{add(Item.Macete);}});
        this.gameRoom.get(3).setObject(new ArrayList<Item>(){{add(Item.ChiaveDellaSerpeSmeraldo);}});
        this.gameRoom.get(3).setGrantedDirections(directions.getOB());
        this.gameRoom.get(3).setEnemy(Enemy.Snakes);

        //quinta stanza, Tempio perduto
        //this.gameRoom[4].setNeededItems(new ArrayList<Item>(){{add(Item.Macete);}});
        this.gameRoom.get(4).setGrantedDirections(directions.getNSB());

        //sesta stanza, Camera dei Riti Sacri
        this.gameRoom.get(5).setGrantedDirections(directions.getNEB());

        //settima stanza, Sala dell'Altare Antico
        this.gameRoom.get(6).setNeededItems(new ArrayList<Item>(){{add(Item.ChiaveDellAvventuriero); add(Item.ChiaveDellaSerpeSmeraldo);}});
        this.gameRoom.get(6).setGrantedDirections(directions.getESOB());

        //ottava stanza, Anticamera
        this.gameRoom.get(7).setObject(new ArrayList<Item>(){{add(Item.PergamenaDelleProfezieAntiche);}});
        this.gameRoom.get(7).setGrantedDirections(directions.getOB());


        //nona stanza, Stanza dell Reliquie Celesti
        this.gameRoom.get(8).setObject(new ArrayList<Item>(){{add(Item.CaliceDelSangueSanto);}});
        this.gameRoom.get(8).setGrantedDirections(directions.getNESB());

        //decima stanza, Covo delle Anime Perdute
        this.gameRoom.get(9).setObject(new ArrayList<Item>(){{add(Item.LanternaDellEternaPenombra);}});
        this.gameRoom.get(9).setGrantedDirections(directions.getNEOB());

        //undicesima stanza, Stanza degli Enigmi
        this.gameRoom.get(10).setNeededItems(new ArrayList<Item>(){{add(Item.PergamenaDelleProfezieAntiche);}});
        this.gameRoom.get(10).setGrantedDirections(directions.getOB());
        this.gameRoom.get(10).setObject(new ArrayList<Item>(){{add(Item.ChiaveDelTesoroAntico);}});

        //dodicesima stanza, Antro dell'Oscurità
        this.gameRoom.get(11).setNeededItems(new ArrayList<Item>(){{add(Item.LanternaDellEternaPenombra);}});
        this.gameRoom.get(11).setGrantedDirections(directions.getSB());

        //tredicesima stanza, Corridoio dei Destini Intrecciati
        this.gameRoom.get(12).setGrantedDirections(directions.getESB());

        //quattordicesima stanza, Stanza del Tesoro
        this.gameRoom.get(13).setNeededItems(new ArrayList<Item>(){{add(Item.ChiaveDelTesoroAntico); add(Item.CaliceDelSangueSanto); add(Item.Macete);}});
        this.gameRoom.get(13).setObject(new ArrayList<Item>(){{add(Item.TesoroAntico);}});
        this.gameRoom.get(13).setGrantedDirections(directions.getNOB());
    }*/

}
