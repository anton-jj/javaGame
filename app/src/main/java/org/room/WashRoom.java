package org.room;

import org.util.GameObject;
import org.util.printUtil;
import org.item.Key;
public class WashRoom extends Room{
    public WashRoom(){
        super(RoomName.WASH_ROOM);
    }
    @Override
    protected void createObjects(){
        GameObject mirror = new GameObject(printUtil.AsciiArt.MIRROR_ASCII.getArt(), "mirror", false);
        GameObject shower = new GameObject(printUtil.AsciiArt.SHOWER_ASCII.getArt(), "shower", false);
        objectManager.addObject(mirror);
        objectManager.addObject(shower);
        Key key = new Key();
        mirror.addItem(key);
    }
}
