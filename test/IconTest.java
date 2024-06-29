import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

public class IconTest {

    @Test
    void setImage_validImage() {
        // Arrange
        Icon icon = new Icon();
        BufferedImage expectedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        // Act
        icon.setImage(expectedImage);

        // Assert
        assertEquals(expectedImage, icon.image, "Image should be set correctly");
    }

    @Test
    void setImage_nullImage() {
        // Arrange
        Icon icon = new Icon();

        // Act
        icon.setImage(null);

        // Assert
        assertNull(icon.image, "Image should be set to null");
    }

    // Additional test cases can be added for edge cases
}
