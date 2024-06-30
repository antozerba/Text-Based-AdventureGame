public class ObjectGame {

    //definisco gli attributi della classe object
    private Item name;
    private String description;
    private static int ID;  //codice univoco che mi indentifica l'oggetto

    /**
     * Costruttore con parametro
     * @param nome
     */
    public ObjectGame(Item nome){
        this.name = nome;
        this.description = "";
    }

    /**
     * Costruttore con parametro
     * @param name
     * @param description
     */
    public ObjectGame(Item name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Metodi Getter e Setter
     * @return
     */
    public Item getName() {
        return name;
    }

    public void setName(Item name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        ObjectGame.ID = ID;
    }
}
