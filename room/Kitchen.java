package room;

import util.GameObject;
import util.printUtil;

public class Kitchen extends Room {
    public Kitchen(){
        super(RoomName.KITCHEN);
    }

    @Override
    protected void createObjects(){
        GameObject oven = new GameObject(printUtil.AsciiArt.OVEN_ASCII.getArt(), "oven", true);
        GameObject fridge = new GameObject(printUtil.AsciiArt.FRIDGE_ASCII.getArt(), "fridge", true);

        objectManager.addObject(fridge);
        objectManager.addObject(oven);
    }
}
