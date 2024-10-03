package player;

import java.util.ArrayList;

import item.Item;
import room.Room;
import util.GameObject;
import util.ObjectManager;
import util.printUtil;
public class Player {

    private int keyCount;
    private Room currentRoom;
    private int hp;
    private int damage;
    private ArrayList<Object> inventory; 

    public Player(Room startRoom, int damage, int hp) {
        this.keyCount = 0;
        this.currentRoom = startRoom;
        this.hp = hp; 
        this.damage = damage;
        this.inventory = new ArrayList<>();

    }
    public ObjectManager getObjectManager(){
        return currentRoom.getObjectManager();
    }

    public int getKeyCount() {
        return keyCount;
    }

    public Room getCurentRoom(){
        return currentRoom;
    }
    // TODO fix so the input is not "pickup mirror"
    public void pickup(String item) {
        ObjectManager objectManager = currentRoom.getObjectManager();
        GameObject obj = objectManager.objectsbyName(item);
        
        if(obj == null) {
            System.out.println("Invalid object");
            return;
        }
        if(obj.hasItem()) {
            Item itemToPickup = obj.getItems().get(0);
            
            inventory.add(itemToPickup);
            obj.removeItem(itemToPickup);
            
            System.out.println("You picked up: " + itemToPickup.getName());
        }
    }

    public void search(String objectName) {
        ObjectManager objectManager = currentRoom.getObjectManager();
        GameObject obj = objectManager.objectsbyName(objectName);

        if (obj == null) {
            System.out.println("Invalid object");
            return;
        }

        if(obj.isOpenable()) {
            System.out.println("try open");
            return;
        }

        System.out.println(obj.interact());
         
        if (obj.hasItem()) {
            System.out.println("Items found at " + obj.getName() + ": ");
            for(Item item : obj.getItems()) {
                System.out.println("- " + item.getName());
            }
        } else {
            System.out.println("there is nothing at " + obj.getName());
        }
    }

    public void open(String objectName) {
        ObjectManager objectManager = currentRoom.getObjectManager();
        GameObject obj = objectManager.objectsbyName(objectName);

           if (obj == null) {
            System.out.println("Input valid object");
            return;
        }

        if (!obj.isOpenable()) {
            System.out.println(obj.isOpenable());
            System.out.println("sorry try search?");
            return;
        }

        System.out.println(obj.interact()); 

        if (obj.hasItem()) {
            System.out.println("Inside the " + obj.getName() + " you found " );
            for (Item item : obj.getItems()){
                System.out.println("-" + item.getName());
            }
        } else {
            System.out.println("there is nothing at " + obj.getName());
        }
    }

    public void look() {
        ObjectManager objectManager = currentRoom.getObjectManager();
        System.out.print("You look arotund and find\n");
        for (GameObject obj : objectManager.getObjects()) {
            printUtil.typeWriter(obj.getName());
        }
    }

    public int incrementKey() {
        return keyCount++;
    }

    public void takeDamage(int amount) {
        this.hp -= amount;
    }

    public boolean isAlive(){
        return hp > 0;
    }
    
    public void go(String roomName,ArrayList<Room> rooms) {
        for (Room room : rooms){
            if (room.getName().equalsIgnoreCase(roomName)) {
                currentRoom = room;
                System.out.println("you moved to " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());
                return;
            }
        }
        System.out.println("Room not found " + roomName);
    }
    public void talk(){
        System.out.println("not implmented");
    }
}
