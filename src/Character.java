//classe del personaggio principale
import java.util.ArrayList;

public class Character {
    //attributi del personaggio
    private String name;
    private ArrayList<Item> backpack;

    /**
     * Cotruttori
     */
    public Character(){
        this.name = null;
        this.backpack = new ArrayList<Item>();
    }

    public Character(String name){
        this.name = name;
        this.backpack = new ArrayList<Item>();
    }

    /**
     * Metodi Getter e Setter
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getBackpack() {
        return backpack;
    }

    public void setBackpack(ArrayList<Item> backpack) {
        this.backpack = backpack;
    }

    /**
     * Metodo che permette di aggiungere un Item al backpack del personaggio
     * @param item
     * @return
     */
    public boolean addItem(Item item){
        if(this.backpack.size() < 5){
            this.backpack.add(item);
            return true;
        }else{
            return false;
        }

    }
}

