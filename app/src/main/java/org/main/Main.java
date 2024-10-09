package org.main;
import org.game.Game;
import org.util.printUtil;
public class Main {
    public static void main(String[] args) {
        // Skapa en instans av Game, som hanterar allt spelets logik
        Game game = new Game();
        
        // Starta spelet
        System.out.println(printUtil.AsciiArt.HOUSE_ASCII.getArt());
        printUtil.typeWriter(printUtil.GameMessages.WELCOME_MESSAGE.getMessage());
        game.start();
    }
}
