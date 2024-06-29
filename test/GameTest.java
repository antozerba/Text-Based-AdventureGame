import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() throws IOException, FontFormatException {
       Game game = new Game(); // Initialize the Game instance
    }

    @Test
    void startGame() {
        // Mock necessary components
        StartGui startGuiMock = mock(StartGui.class);
        Logic logicMock = mock(Logic.class);
        VisibilityManager managerMock = mock(VisibilityManager.class);

        // Set up mock interactions
        when(startGuiMock.isVisible()).thenReturn(true); // Simulate visibility check
        game.setStartGui(startGuiMock);
        game.setLogic(logicMock);
        game.setManager(managerMock);

        // Call startGame method
        game.startGame();

        // Verify that necessary components were initialized or configured
        assertNotNull(game.getStartGui()); // Verify startGui was initialized
        assertNotNull(game.getLogic()); // Verify logic was initialized
        assertNotNull(game.getManager()); // Verify manager was initialized

        // Additional verifications based on expected behaviors of startGame()
        verify(startGuiMock).setVisible(false); // Ensure startGui visibility was managed
        // Add more assertions as per your game's initialization logic
    }
}
