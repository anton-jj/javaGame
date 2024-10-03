package util;

import java.util.ArrayList;
import java.util.List;
import item.*;

public class GameObject {
    String name;
    private List<Item> items; 
    boolean visableKey;
    boolean openAble;
    private String asciiArt;
    

    public GameObject(String asciiArt, String name, boolean openAble) {
        this.openAble = openAble;
        this.name = name;
        this.items = new ArrayList<>();
        this.asciiArt = asciiArt;
    }

    public boolean isOpenable(){
        return openAble;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems(){
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItembyName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }
    
    public String interact(){
     return asciiArt;
    }

    public boolean hasItem() {
        return !items.isEmpty();
    }
    
    public List<Item> getStoredItem() {
        return items; 
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}