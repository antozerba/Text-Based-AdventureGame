/**
 * Classe per la gestione di una singola immagine tramite un BufferImage
 */

import java.awt.image.BufferedImage;

public class Icon {
    public BufferedImage image;

    /**
     * Costruttore
     */
    public Icon() {
        this.image = null;
    }

    /**
     * Setter
     * @param image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
