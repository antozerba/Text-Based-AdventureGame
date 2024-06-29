import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

class VisibilityManagerTest {

    private VisibilityManager visibilityManager;
    private RoomGUI mockGui;
    private Logic mockLogic;

    @BeforeEach
    void setUp() {
        mockGui = Mockito.mock(RoomGUI.class);
        mockLogic = Mockito.mock(Logic.class);
        JTextField mockTextField = Mockito.mock(JTextField.class);
        when(mockTextField.getText()).thenReturn("test command");

        // Configura mock di RoomGUI per restituire il mock di JTextField
        when(mockGui.getTextField()).thenReturn(mockTextField);
        // Mock per restituire una stanza valida quando getActRoom() viene chiamato
        Room mockRoom = new Room("Mock Room");
        when(mockLogic.getActRoom()).thenReturn(mockRoom);

        visibilityManager = new VisibilityManager(mockGui, mockLogic);
    }

    @Test
    void testKeyPressed_Enter() {
        KeyEvent mockEvent = Mockito.mock(KeyEvent.class);
        when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);

        visibilityManager.keyPressed(mockEvent);

        // Assicurati che il metodo receiveInput del command sia chiamato correttamente
        verify(mockLogic, times(1)).getActRoom();
        // Esempio di ulteriori verifiche
        verify(mockGui, times(1)).getTextField();
        verify(mockLogic, times(1)).nextRoom(any(), eq("test command"));
    }

    // Aggiungi altri test secondo necessità per altri scenari di input
}
