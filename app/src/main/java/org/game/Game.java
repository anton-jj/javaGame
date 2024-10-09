package org.game;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.npc.FriendlyGhost;
import org.player.Player;
import org.room.Hall;
import org.room.Kitchen;
import org.room.LivingRoom;
import org.room.Room;
import org.room.WashRoom;
import org.util.printUtil;

public class Game {
    private final Player player;
    private Room currentRoom;
    private final Scanner scanner;
    private FriendlyGhost friendlyGhost;
    private ArrayList<Room> rooms;
    public Game() {
        this.rooms = new ArrayList<>();
        setupRooms();
        this.player = new Player(currentRoom, 200, 50);
        this.scanner = new Scanner(System.in);
        this.friendlyGhost = new FriendlyGhost(this);
    }

    private void setupRooms(){
        Room hall = new Hall();
        Room kitchen = new Kitchen();
        Room livingRoom = new LivingRoom();
        Room washroom = new WashRoom();
        rooms.add(kitchen);
        rooms.add(hall);
        rooms.add(livingRoom);
        rooms.add(washroom);

        // fixa move command så man kan gå mellan olika rum nu ör det en cirkel living room -> hall -> kitchen -> livingroom
        
        currentRoom = livingRoom;

    }

    public void start() {
        boolean playing = true;
        System.out.println(printUtil.GameMessages.MENU_MESSAGE.getMessage());
        while (player.getKeyCount() != 2 && playing) {

            String[] parts = handleINput();
            String command = parts[0];
            String argument = (parts.length > 1) ? parts[1] : "";

            switch (command) {
                case "open":
                    player.open(argument);
                    break;
                case "menu":
                    System.out.println(printUtil.GameMessages.MENU_MESSAGE.getMessage());
                    break;
                case "pickup":
                    player.pickup(argument);
                    break;
                case "look":
                    player.look();
                    break;
                case "search":
                    player.search(argument);
                    break;
                case "exit":
                    playing = false;
                    break;
                case "go":
                    player.go(argument, getRooms());
                    break;
                case "talk":
                    friendlyGhost.showMenu();
                    break;
                default:
                    System.out.println("Not valid command: " + command);
                    break;
            }
            System.out.println();
        }
    }
    private String[] handleINput() {
    try {
        String input = scanner.nextLine().toLowerCase();
        if (input.isBlank()) {
            System.out.println("Enter valid input");
            return handleINput(); // Prompt again
        }
        return input.split(" ", 2);
    } catch (NoSuchElementException e) {
        System.out.println("No input available. Exiting the game.");
        System.exit(0); // Graceful exit
    }
    return new String[0]; // Fallback
}
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    public Player getPlayer(){
        return player;
    }
}
