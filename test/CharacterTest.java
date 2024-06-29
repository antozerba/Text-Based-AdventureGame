import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {

    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(null, character.getName());
        assertEquals(0, character.getBackpack().size());
    }

    @Test
    void testParameterizedConstructor() {
        Character characterWithName = new Character("Alice");
        assertEquals("Alice", characterWithName.getName());
        assertEquals(0, characterWithName.getBackpack().size());
    }

    @Test
    void testGetName() {
        character.setName("Bob");
        assertEquals("Bob", character.getName());
    }

    @Test
    void testSetName() {
        character.setName("Charlie");
        assertEquals("Charlie", character.getName());
    }

    @Test
    void testGetBackpack() {
        assertEquals(0, character.getBackpack().size());
    }

    @Test
    void testSetBackpack() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(Item.Torcia);
        character.setBackpack(items);
        assertEquals(1, character.getBackpack().size());
        assertEquals("Torcia", character.getBackpack().get(0).toString());
    }

    @Test
    void testAddItem() {
        assertTrue(character.addItem(Item.Torcia));
        assertEquals(1, character.getBackpack().size());

        assertTrue(character.addItem(Item.Macete));
        assertEquals(2, character.getBackpack().size());
    }
}
