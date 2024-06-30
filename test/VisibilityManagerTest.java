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
    private Command mockCommand;

    @BeforeEach
    void setUp() {
        mockGui = Mockito.mock(RoomGUI.class);
        mockLogic = Mockito.mock(Logic.class);
        mockCommand = Mockito.mock(Command.class);

        JTextField mockTextField = Mockito.mock(JTextField.class);
        when(mockTextField.getText()).thenReturn("test command");

        // Configure mock RoomGUI to return the mock JTextField
        when(mockGui.getTextField()).thenReturn(mockTextField);

        // Configure mock Logic to return a valid Room when getRoomByIndex(int) is called
        Room mockRoom = new Room("Mock Room");
        when(mockLogic.getRoomByIndex(anyInt())).thenReturn(mockRoom);

        visibilityManager = new VisibilityManager(mockGui, mockLogic);

        // Set the Command object manually
        visibilityManager.command = mockCommand;
    }

    @Test
    void testKeyPressed_Enter() {
        KeyEvent mockEvent = Mockito.mock(KeyEvent.class);
        when(mockEvent.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);

        visibilityManager.keyPressed(mockEvent);

        // Verify that the receiveInput method of the command is called correctly
        verify(mockCommand, times(1)).receiveInput("test command");
    }
}
