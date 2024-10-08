package npc;

import game.Game;
import java.util.Random;
import java.util.Scanner;
import room.Room;
import util.printUtil;

public class FriendlyGhost extends Npc {
    private Random random;
    private Game game;

    public FriendlyGhost(Game game) {
        super("ivan", "a cute little ghost", 200, 10);
        this.game = game;
        this.random = new Random();
    }
    public void showMenu() {
        boolean showMenu = true;
        printUtil.typeWriter(printUtil.GameMessages.NPC_GHOST_HELP.getMessage());
        printUtil.typeWriter(printUtil.AsciiArt.GHOST_ASCII.getArt());
        while(showMenu) {
            System.out.println("""
                    What would you like to do?
                    1. map
                    2. talk
                    3. exit menu
                    """);
            
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    switch(choice){
                        case "1":
                        showMap();
                        break;
                        case "2":
                        interact();
                        break;
                        case "3":
                            showMenu = false;
                        break;
                        default:
                            System.out.println("Invalid choice");
                    }
        }

    }
    @Override
    public void interact() {
        int index = random.nextInt(4);
        switch (index){
            case 1:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_1.getMessage());
                break;
            case 2:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_2.getMessage());
                break;
            case 3:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_3.getMessage());
                break;
            case 4:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_4.getMessage());
                break;
        }
    }
    private void showMap(){
        System.out.println("You are now in the" + game.getPlayer().getCurentRoom().getName());
        for (Room room : game.getRooms()) {
           System.out.println(room.getName());
        }
    }
}
