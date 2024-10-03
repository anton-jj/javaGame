package room;

import util.GameObject;
import util.printUtil;
public class Hall extends Room {
    public Hall(){
        super(RoomName.HALL);
    }
    @Override
    protected void createObjects(){
        GameObject carpet = new GameObject(printUtil.AsciiArt.CARPET_ASCII.getArt(), "carpet", false); 
        GameObject painting = new GameObject(printUtil.AsciiArt.PAINTING_ASCII.getArt(), "painting", false);

        objectManager.addObject(carpet);
        objectManager.addObject(painting);
    }
}
