package ch.bbw.ns;

import ch.bbw.ns.items.Item;
import ch.bbw.ns.rooms.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Player (Manages player)
 *
 * @author Noelle Senti
 * @version
 */
public class Player {
    private String name;
    private Room currentRoom;
    private char gender;
    private List<Item> items;

    public Player() {
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void getItem(Item item){
        int indexItem = items.indexOf(item);
        items.get(indexItem);
    }
}
