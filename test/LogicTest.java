import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LogicTest {

    @Test
    void testGetScan() {
        Logic logic = new Logic();
        // Assuming getScan returns a value, test its functionality
        assertNotNull(logic.getScan());
    }

    @Test
    void testSetMainCharacter() {
        Logic logic = new Logic();
        logic.setMainCharacter("MainCharacter");
        assertEquals("MainCharacter", logic.getMainCharacter().getName());
    }

    @Test
    void testCreateRoom() {
        Logic logic = new Logic();
        logic.createRoom();
        assertNotNull(logic.getRoomByIndex(0).getName());
    }

    @Test
    void testNextRoom() {
        Logic logic = new Logic();
        logic.setGameRoom(new Room[14]);
        logic.createRoom();
        logic.setRoom();
        logic.nextRoom(logic.getRoomByIndex(0), "nord");
    }


}
