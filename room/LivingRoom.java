package room;

import util.GameObject;

public class LivingRoom  extends Room{
    public LivingRoom(){
        super(RoomName.LIVING_ROOM);
    }

    @Override
    protected void createObjects(){
        getObjectManager().addObject(new GameObject("table",  false));
        getObjectManager().addObject(new GameObject("couch",  false));
        getObjectManager().addObject(new GameObject("lamp",  false));
    }
}
