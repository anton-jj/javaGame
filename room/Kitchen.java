package room;

import util.GameObject;

public class Kitchen extends Room {
    public Kitchen(){
        super(RoomName.KITCHEN);
    }

    @Override
    protected void createObjects(){
        getObjectManager().addObject(new GameObject("oven",  true));
        getObjectManager().addObject(new GameObject("fridge",  true));
        getObjectManager().addObject(new GameObject("bench",  false));
    }
}
