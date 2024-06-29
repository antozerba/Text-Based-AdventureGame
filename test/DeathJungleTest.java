import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DeathJungleTest {

    private static final String UPLOAD_PATH = "src/upload.xml";
    private static final String DOWNLOAD_PATH = "src/download.xml";

    @BeforeEach
    void setUp() throws IOException {
        createTestFile(UPLOAD_PATH);
        createTestFile(DOWNLOAD_PATH);
    }

    private void createTestFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs(); // Ensure the directory exists
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("Test content");
            writer.close();
        }
    }

    @Test
    void main() {
        // We can't directly test the main method that reads from System.in
        // However, we can verify that it doesn't throw any exceptions
        assertDoesNotThrow(() -> DeathJungle.main(new String[]{}));
    }

    @Test
    void deleteFile() {
        // Verify that the files exist before deletion
        assertTrue(new File(UPLOAD_PATH).exists());
        assertTrue(new File(DOWNLOAD_PATH).exists());

        // Call the method to delete files
        DeathJungle.deleteFile();

        // Verify that the files do not exist after deletion
        assertFalse(new File(UPLOAD_PATH).exists());
        assertFalse(new File(DOWNLOAD_PATH).exists());
    }
}
