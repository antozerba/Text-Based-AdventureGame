//classe del personaggio principale
import java.util.ArrayList;

public class Character {
    //attributi del personaggio
    private String name;
    private ArrayList<Item> backpack;

    public Character(String name){
        this.name = name;
        this.backpack = new ArrayList<Item>();
    }

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

    public boolean addItem(Item item){
        if(this.backpack.size() < 5){
            this.backpack.add(item);
            return true;
        }else{
            return false;
        }

    }
}

