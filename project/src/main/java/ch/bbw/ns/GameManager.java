package ch.bbw.ns;

import ch.bbw.ns.people.Person;

import ch.bbw.ns.commands.Command;
import ch.bbw.ns.items.Item;
import ch.bbw.ns.rooms.Room;
import ch.bbw.ns.rooms.TrainStation;

import java.util.List;
import java.util.Set;

/**
 * Game Manager (connects visuals with code)
 *
 * @author Noelle Senti
 */

public class GameManager implements Manager {
    private GameController gameController;
    private Player player;
    private Room currentRoom;
    private StoryLineManager storyLineManager;

    public GameManager(Player player, GameController gameController) {
        System.out.println("Create GameManager");
        this.player = player;
        this.gameController = gameController;
        currentRoom = TrainStation.INSTANCE;

        initialize();
    }

    public void initialize() {
        Person.createPersons();
        storyLineManager = new StoryLineManager(this);
        gameController.setManager(this);
        gameController.update();
        this.player.addItem(Item.PHONE);


        response();
    }

    public void newCommand(String command) {
        //Command verarbeiten
        try {
            Command c = Command.create(command, this);
            if (c != null) {
                c.applyToRoom(currentRoom, this);
            }
        } catch (CommandException e) {
            gameController.showError(e);
        }
    }


    public void addAll(Set<Item> items) {
        for (Item i : items) {
            player.addItem(i);
        }
    }

    @Override
    public boolean hasItem(Item item) {
        if (player.getItems().contains(item)) {
            return true;
        }
        return false;
    }

    @Override
    public void addItem(Item item) {
        player.addItem(item);
    }

    public void gotoRoom(Room room) {
        currentRoom = room;
    }

    @Override
    public void response() {
        String s = storyLineManager.getOutput();
        gameController.outputAnswer(s);
    }

    @Override
    public void getStoryLine() {

    }

    @Override
    public void updateStory() {
        storyLineManager.update();
        gameController.update();
        response();
    }

    @Override
    public void removeItem(Item i) {
        player.removeItem(i);
    }

    @Override
    public String printItem(int a) {
        return player.getItems().get(a).getName();

    }

    @Override
    public String getCurrentRoom() {
        return currentRoom.getName();
    }

    @Override
    public List<Item> getItems() {
        return player.getItems();
    }

    @Override
    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    @Override
    public String getName() {
        return player.getName();
    }

}
