package util;

import java.util.ArrayList;
import java.util.List;
public class ObjectManager {
    private List<GameObject> objects;

    public ObjectManager() {
        objects = new ArrayList<>();
    }
    public void addObject(GameObject obj){
        objects.add(obj);
    }

    public List<GameObject> getObjects(){
        return objects;
    }
    public GameObject objectsbyName(String name) {
        for (GameObject obj : objects) {
            if (obj.getName().equalsIgnoreCase(name)) {
                return obj;
            }
        }
        return null;
    }
}
