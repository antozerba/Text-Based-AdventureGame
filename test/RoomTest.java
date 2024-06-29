import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class RoomTest {

    private Room room;
    private Item testItem;

    @BeforeEach
    void setUp() {
        room = new Room("Test Room");
        testItem = Item.Torcia;
    }

    @Test
    void getName() {
        assertEquals("Test Room", room.getName());
    }

    @Test
    void setName() {
        room.setName("Updated Room Name");
        assertEquals("Updated Room Name", room.getName());
    }

    @Test
    void getThereIsCharacter() {
        assertFalse(room.getThereIsCharacter());
    }

    @Test
    void setThereIsCharacter() {
        room.setThereIsCharacter(true);
        assertTrue(room.getThereIsCharacter());
    }

    @Test
    void getNeededItems() {
        assertNotNull(room.getNeededItems());
        assertTrue(room.getNeededItems().isEmpty());
    }

    @Test
    void setNeededItems() {
        ArrayList<Item> neededItems = new ArrayList<>();
        neededItems.add(testItem);
        room.setNeededItems(neededItems);
        assertEquals(neededItems, room.getNeededItems());
    }

    @Test
    void getObject() {
        assertNotNull(room.getObject());
        assertTrue(room.getObject().isEmpty());
    }

    @Test
    void setObject() {
        ArrayList<Item> object = new ArrayList<>();
        object.add(testItem);
        room.setObject(object);
        assertEquals(object, room.getObject());
    }

    @Test
    void getDescription() {
        assertEquals("", room.getDescription());
    }

    @Test
    void setDescription() {
        room.setDescription("Test Room Description");
        assertEquals("Test Room Description", room.getDescription());
    }

    @Test
    void getGrantedDirections() {
        assertNull(room.getGrantedDirections());
    }

    @Test
    void setGrantedDirections() {
        ArrayList<String> grantedDirections = new ArrayList<>();
        grantedDirections.add("North");
        room.setGrantedDirections(grantedDirections);
        assertEquals(grantedDirections, room.getGrantedDirections());
    }

    @Test
    void addItem() {
        assertTrue(room.addItem(testItem));
        assertTrue(room.getObject().contains(testItem));
    }
}
