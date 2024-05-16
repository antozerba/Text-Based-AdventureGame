import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class IconManager {
    Icon[] iconArray;

    public IconManager() {
        iconArray = new Icon[14];
        addImages();
    }

    public void addImages(){
        try {
            iconArray[0] = new Icon();
            iconArray[0].setImage(ImageIO.read(new File("src/jungle.png")));
            iconArray[2] = new Icon();
            iconArray[2].setImage(ImageIO.read(new File("src/savana.png")));
            /*iconArray[2] = new Icon();
            iconArray[2].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[3] = new Icon();
            iconArray[3].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[4] = new Icon();
            iconArray[4].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[5] = new Icon();
            iconArray[5].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[6] = new Icon();
            iconArray[6].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[7] = new Icon();
            iconArray[7].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[8] = new Icon();
            iconArray[8].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[9] = new Icon();
            iconArray[9].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[10] = new Icon();
            iconArray[10].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[10] = new Icon();
            iconArray[11].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[11] = new Icon();
            iconArray[12].setImage(ImageIO.read(new File("src/savana.png")));
            iconArray[12] = new Icon();
            iconArray[13].setImage(ImageIO.read(new File("src/savana.png")));*/


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
