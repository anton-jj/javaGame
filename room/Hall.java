package room;

import util.GameObject;
public class Hall extends Room {
    public Hall(){
        super(RoomName.HALL);
    }
    @Override
    protected void createObjects(){
        getObjectManager().addObject(new GameObject("carpet", false));
        getObjectManager().addObject(new GameObject("paintin", false));
        getObjectManager().addObject(new GameObject("chest", true));
    }
}
