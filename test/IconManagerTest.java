import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IconManagerTest {

    private IconManager iconManager;

    @BeforeEach
    void setUp() {
        iconManager = new IconManager();
    }

    @Test
    void addImages() {
        // Test each icon in the iconArray
        for (int i = 0; i < iconManager.iconArray.length; i++) {
            Icon icon = iconManager.iconArray[i];

            // Check that the image is not null
            assertNotNull(icon.image, "Icon " + i + " should have a non-null image");

            // Check that the image dimensions are valid (assuming images are correctly loaded)
            BufferedImage image = icon.image;
            assertTrue(image.getWidth() > 0 && image.getHeight() > 0,
                    "Icon " + i + " should have a valid image dimensions");

            // Optionally, check specific properties of each image if needed
            // For example, check pixel color or transparency
        }
    }

    // Additional tests can be added to verify specific behavior or edge cases

}
