/**
 * Classe che gestisce lo storing della varie immagini in una array di BufferImage
 */
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class IconManager {
    Icon[] iconArray;

    public IconManager() {
        iconArray = new Icon[14];
        addImages();
    }

    /**
     * Metodo che inserisce le immagini nell'array iconArray
     */
    public void addImages(){
        try {
            iconArray[0] = new Icon();
            iconArray[0].setImage(ImageIO.read(new File("src/images/jungle.png")));
            iconArray[1] = new Icon();
            iconArray[1].setImage(ImageIO.read(new File("src/images/pluviale.png")));
            iconArray[2] = new Icon();
            iconArray[2].setImage(ImageIO.read(new File("src/images/boscaglia.png")));
            iconArray[3] = new Icon();
            iconArray[3].setImage(ImageIO.read(new File("src/images/snakeroom.png")));
            iconArray[4] = new Icon();
            iconArray[4].setImage(ImageIO.read(new File("src/images/tempio_perduto.png")));
            iconArray[5] = new Icon();
            iconArray[5].setImage(ImageIO.read(new File("src/images/sala_riti.png")));
            iconArray[6] = new Icon();
            iconArray[6].setImage(ImageIO.read(new File("src/images/altare.png")));
            iconArray[7] = new Icon();
            iconArray[7].setImage(ImageIO.read(new File("src/images/anticamera.png")));
            iconArray[8] = new Icon();
            iconArray[8].setImage(ImageIO.read(new File("src/images/reliquie.png")));
            iconArray[9] = new Icon();
            iconArray[9].setImage(ImageIO.read(new File("src/images/anime_perdute.png")));
            iconArray[10] = new Icon();
            iconArray[10].setImage(ImageIO.read(new File("src/images/stanza_degli_enigmi.png")));
            iconArray[11] = new Icon();
            iconArray[11].setImage(ImageIO.read(new File("src/images/atrio_oscurita.png")));
            iconArray[12] = new Icon();
            iconArray[12].setImage(ImageIO.read(new File("src/images/corridoio.png")));
            iconArray[13] = new Icon();
            iconArray[13].setImage(ImageIO.read(new File("src/images/tesoro.png")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
