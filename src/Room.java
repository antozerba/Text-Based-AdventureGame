import java.util.ArrayList;

public class Room {
    //attributi di Room
    private String name;    //nome della stanza
    private Enemy enemy;    //nemico che possiamo trovare nella stanza
    private boolean thereIsCharacter;  //true se il personaggio principale è presente, false altrimenti
    private ArrayList<Item> neededItems;
    private ArrayList<Item> object;    //oggetti che si possono trovare all'interno della stanza
    private String description;
    private ArrayList<String> grantedDirections;

    //costruttori
    public Room(){
        this.name = "";
        this.enemy = null;
        this.thereIsCharacter = false;
        this.neededItems = new ArrayList<Item>();
        this.object = new ArrayList<Item>();;
        this.description = "";
        this.grantedDirections = null;
    }

    public Room(String name){
        this.name = name;
        this.enemy = null;
        this.thereIsCharacter = false;
        this.neededItems = new ArrayList<Item>();;
        this.object = new ArrayList<Item>();;
        this.description = "";
        this.grantedDirections = null;
    }

    public Room(String name, Enemy enemy) {
        this.name = name;
        this.enemy = enemy;
        this.thereIsCharacter = false;
        this.neededItems = new ArrayList<Item>();;
        this.object = new ArrayList<Item>();;
        this.description = "";
        this.grantedDirections = null;
    }
    public Room(String name, Enemy enemy, ArrayList<Item> object){
        this.name = name;
        this.enemy = enemy;
        this.thereIsCharacter = false;
        this.neededItems = new ArrayList<Item>();
        this.object = object;
        this.description = "";
        this.grantedDirections = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean getThereIsCharacter() {
        return thereIsCharacter;
    }

    public void setThereIsCharacter(boolean thereIsCharacter) {
        this.thereIsCharacter = thereIsCharacter;
    }

    public ArrayList<Item> getNeededItems() {
        return neededItems;
    }

    public void setNeededItems(ArrayList<Item> neededItems) {
        this.neededItems = neededItems;
    }

    public ArrayList<Item> getObject() {
        return object;
    }

    public void setObject(ArrayList<Item> object) {
        this.object = object;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getGrantedDirections() {
        return grantedDirections;
    }

    public void setGrantedDirections(ArrayList<String> grantedDirections) {
        this.grantedDirections = grantedDirections;
    }

    public boolean addItem(Item item){
        if(this.object.add(item)){
            return true;
        }else{
            return false;
        }
    }
}
