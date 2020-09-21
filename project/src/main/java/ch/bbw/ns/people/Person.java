package ch.bbw.ns.people;

import ch.bbw.ns.CommandException;
import ch.bbw.ns.Manager;
import ch.bbw.ns.items.Item;

import java.util.*;

/**
 * Person (manages all people)
 *
 * @author Noelle Senti
 */

public abstract class Person {

    private static final Map<String, Person> ALL_PEOPLE = new HashMap<>();
    protected List<Item> ownedItems = new ArrayList<>();
    protected List<Item> wantedItems = new ArrayList<>();

    public static void createPersons() {
        ALL_PEOPLE.put("jane", new Jane());
        ALL_PEOPLE.put("tim", new Tim());
    }

    public static Person get(String name) {
        Person p = ALL_PEOPLE.get(name);
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return p;
    }

    public abstract String getName();

    protected boolean accept(Item item) {
        return false;
    }

    public void give(Item item, Manager m) {
        if (accept(item)) {
            ownedItems.add(item);
            m.response();
        } else {
            throw new CommandException(getName() + " rejected the " + item);
        }
    }

    public void addOwnedItem(Item item) {
        ownedItems.add(item);
    }

    public List<Item> getOwnedItems() {
        return ownedItems;
    }

    public void setOwnedItems(List<Item> ownedItems) {
        this.ownedItems = ownedItems;
    }

    public void removeOwnedItem(Item item) {
        ownedItems.remove(item);
    }

    public void addWantedItem(Item item) {
        wantedItems.add(item);
    }

    public List<Item> getWantedItems() {
        return wantedItems;
    }

    public void setWantedItems(List<Item> wantedItems) {
        this.wantedItems = wantedItems;
    }

    public void removeWantedItem(Item item) {
        wantedItems.remove(item);
    }
}
