package ch.bbw.ns;

import ch.bbw.ns.items.Item;
import ch.bbw.ns.rooms.Room;

import java.util.List;
import java.util.Set;

/**
 * Manager
 *
 * @author Noelle Senti
 * @version
 */
public interface Manager {
    void newCommand(String command);

    void addAll(Set<Item> items);

    boolean hasItem(Item bread);

    void addItem(Item bread);

    void gotoRoom(Room room);

    void response();

    void getStoryLine();

    void updateStory();

    void removeItem(Item i);

    String printItem(int a);

    String getCurrentRoom();

    List<Item> getItems();

    void setCurrentRoom(Room room);

    String getName();
}
