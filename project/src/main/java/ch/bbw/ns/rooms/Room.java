package ch.bbw.ns.rooms;

import ch.bbw.ns.CommandException;
import ch.bbw.ns.people.Person;

import ch.bbw.ns.items.Item;
import ch.bbw.ns.Manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Room Class
 *
 * @author Noelle Senti
 */
public abstract class Room {
    protected boolean hasTaken;
    protected String name;
    private static final Map<String, Room> ALL_ROOMS = new HashMap<>();
    private final Set<Person> people = new HashSet<>();
    private final Set<Item> items = new HashSet();
    protected final Set<Room> rooms = new HashSet();

    public Room(){
        createRooms();
    }

    public void createRooms(){
        ALL_ROOMS.put("entrance", Entrance.INSTANCE);
        ALL_ROOMS.put("veranda", Veranda.INSTANCE);
        ALL_ROOMS.put("trainStation", TrainStation.INSTANCE);
    }

    public static Room get(String room) {
        Room r = ALL_ROOMS.get(room);
        if (r == null) {
            throw new IllegalArgumentException();
        }
        return r;
    }

    protected boolean isHere(Person person) {
        return people.contains(person);
    }

    protected void addItem(Item item) {
        items.add(item);
    }

    protected void removePerson(Person p) {
        people.remove(p);
    }

    protected void addRoom(Room r){
        rooms.add(r);
    }

    protected void addPerson(Person person) {
        people.add(person);
    }


    public void use(Manager manager, Item i) {
        if (manager.hasItem(i)) {
            throw new CommandException(i.getName() + " is not available!");
        } else {
            manager.removeItem(i);
            manager.updateStory();
        }
    }

    public void talk(Manager manager, Person person) {
        if (people.contains(person)) {
            throw new CommandException(person.getName() + " is not here!");
        } else {
            manager.updateStory();
        }
    }

    public void go(Manager manager, Room room) {
        if (room.containsRoom(room)) {
            throw new CommandException(room.getName() + " is not adjacent!");
        } else {
            manager.updateStory();
        }
    }

    protected boolean containsRoom(Room room){
        return rooms.contains(room);
    }

    public String getName(){
        return name;
    }
}
