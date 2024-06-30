import org.apache.commons.configuration.ConfigurationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private Command command;
    private RoomGUI gui;
    private Logic logic;

    @BeforeEach
    void setUp() throws ConfigurationException {
        gui = new RoomGUI();
        logic = new Logic();
        command = new Command(gui, logic);
        this.logic.setGameRoom(new Room[14]);
        this.logic.createRoom();
        this.logic.setRoom();
    }

    @Test
    void setCount() {
        command.setCount(5);
        assertEquals(5, command.count);
    }

    @Test
    void receiveInput() {
        // Test for valid command that moves the player
        logic.setActRoom(new Room("room1", new ArrayList<Item>() {{add(Item.Torcia);}}));
        gui.getTextField().setText("nord");
        command.receiveInput("nord");
        assertEquals("Room Description\nItems", gui.getTextArea().getText());

        // Test for invalid command
        gui.getTextField().setText("invalid");
        command.receiveInput("invalid");
        assertEquals("Comando non riconosciuto!", gui.getTextArea().getText());
    }


    @Test
    void changeRoom() {
        // Change to a new room
        logic.setActRoom(new Room("room1", new ArrayList<Item>() {{add(Item.Torcia);}}));
        command.changeRoom();
        assertEquals("Room Description\nItems", gui.getTextArea().getText());
    }

    @Test
    void plusCommand() {
        // Test the help command
        command.plusCommand(new String[]{"help"});
        assertEquals("Questi sono tutti i comandi che puoi usare:\n" +
                "1) Comandi direzionali [nord, sud, est, ovest] --> ti permettono di spostarti all'interno dellla mappa\n" +
                "2) Comando [back] --> ti permette di tornare alla stanza precedente\n" +
                "3) Comando [take <item>] --> ti permette di mettere nel tuo zaino un item che trovi nelle varie stanze\n" +
                "4) Comando [release <item>] --> ti permette di togliere dallo zaino un item\n" +
                "5) Comando [backpack] --> ti permette di visualizzare quello che c'è nello zaino\n" +
                "6) Comando [now] --> indica la stanza in cui attualemnte ci troviamo\n", gui.getTextArea().getText());

        // Test the backpack command
        command.plusCommand(new String[]{"backpack"});
        assertEquals("Nel tuo zaino hai: \n", gui.getTextArea().getText());
    }

    @Test
    void helpFunction() {
        command.helpFunction();
        assertEquals("Questi sono tutti i comandi che puoi usare:\n" +
                "1) Comandi direzionali [nord, sud, est, ovest] --> ti permettono di spostarti all'interno dellla mappa\n" +
                "2) Comando [back] --> ti permette di tornare alla stanza precedente\n" +
                "3) Comando [take <item>] --> ti permette di mettere nel tuo zaino un item che trovi nelle varie stanze\n" +
                "4) Comando [release <item>] --> ti permette di togliere dallo zaino un item\n" +
                "5) Comando [backpack] --> ti permette di visualizzare quello che c'è nello zaino\n" +
                "6) Comando [now] --> indica la stanza in cui attualemnte ci troviamo\n", gui.getTextArea().getText());
    }

    @Test
    void backpackViewer() {
        logic.getMainCharacter().addItem(Item.Torcia);
        logic.getMainCharacter().addItem(Item.Macete);
        command.backpackViewer();
        assertEquals("Nel tuo zaino hai: \n0)item1\n1)item2\n", gui.getTextArea().getText());
    }

    @Test
    void nowFunction() {
        command.nowFunction();
        assertEquals("Ti trovi: room1", gui.getTextArea().getText());
    }

    @Test
    void indovinelliTempio() {
        gui.getTextField().setText("candela");
        boolean result = command.indovinelliTempio("candela");
        assertTrue(result);
        assertEquals("Complimenti hai indovinato, puoi proseguire con la tua avventura!", gui.getTextArea().getText());

        gui.getTextField().setText("wrong");
        result = command.indovinelliTempio("wrong");
        assertFalse(result);
        assertEquals("Riprova", gui.getTextArea().getText());
    }

    @Test
    void save() {
        try {
            assertTrue(command.save());
        } catch (ConfigurationException e) {
            fail("ConfigurationException thrown: " + e.getMessage());
        }
    }

    @Test
    void createFile() {
        command.createFile();
        File file = new File("src/upload.xml");
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
}
