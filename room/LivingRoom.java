package room;

import util.GameObject;
import util.printUtil;

public class LivingRoom  extends Room{
    public LivingRoom(){
        super(RoomName.LIVING_ROOM);
    }

    @Override
    protected void createObjects(){
        GameObject sofa = new GameObject(printUtil.AsciiArt.SOFA_ASCII.getArt(), "sofa", false);
        GameObject table = new GameObject(printUtil.AsciiArt.TABLE_ASCII.getArt(), "table", false);
        
        objectManager.addObject(table);
        objectManager.addObject(sofa);
    }
}
