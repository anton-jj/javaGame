package util;

import java.util.ArrayList;
import java.util.List;
import item.*;

public class GameObject {
    String name;
    private List<Item> items; 
    boolean visableKey;
    boolean open;
    

    public GameObject(String name, boolean open) {
        this.open = open;
        this.name = name;
        this.items = new ArrayList<>();
    }

    public boolean getOpen(){
        return open;
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