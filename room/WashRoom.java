package room;

import util.GameObject;
import item.Key;
public class WashRoom extends Room{
    public WashRoom(){
        super(RoomName.WASH_ROOM);
    }
    @Override
    protected void createObjects(){
        GameObject mirror = new GameObject("mirror", false);
        objectManager.addObject(mirror);
        Key key = new Key();
        mirror.addItem(key);
    }
}
