import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObjectGameTest {

    @Test
    void getName() {
        // Arrange
        Item item = Item.Torcia;
        ObjectGame objectGame = new ObjectGame(item);

        // Act
        Item retrievedItem = objectGame.getName();

        // Assert
        assertEquals(item, retrievedItem);
    }

    @Test
    void setName() {
        // Arrange
        Item item1 = Item.ChiaveDellaSerpeSmeraldo;
        Item item2 = Item.ChiaveDellAvventuriero;
        ObjectGame objectGame = new ObjectGame(item1);

        // Act
        objectGame.setName(item2);

        // Assert
        assertEquals(item2, objectGame.getName());
    }

    @Test
    void getDescription() {
        // Arrange
        Item item = Item.Macete;
        ObjectGame objectGame = new ObjectGame(item, "Una chiave dorata");

        // Act
        String description = objectGame.getDescription();

        // Assert
        assertEquals("Una chiave dorata", description);
    }

    @Test
    void setDescription() {
        // Arrange
        Item item = Item.PergamenaDelleProfezieAntiche;
        ObjectGame objectGame = new ObjectGame(item, "Una chiave dorata");

        // Act
        objectGame.setDescription("Una chiave argentea");

        // Assert
        assertEquals("Una chiave argentea", objectGame.getDescription());
    }

    @Test
    void getID() {
        // Arrange & Act
        ObjectGame.setID(1);

        // Assert
        assertEquals(1, ObjectGame.getID());
    }

    @Test
    void setID() {
        // Arrange & Act
        ObjectGame.setID(1);

        // Assert
        assertEquals(1, ObjectGame.getID());

        // Act
        ObjectGame.setID(2);

        // Assert
        assertEquals(2, ObjectGame.getID());
    }
}
