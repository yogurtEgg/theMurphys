package ch.bbw.ns.rooms;

import ch.bbw.ns.people.Jane;
import ch.bbw.ns.people.Person;
import ch.bbw.ns.items.Item;
import ch.bbw.ns.Manager;

/**
 * Veranda, Room
 *
 * @author Noelle Senti
 */
public class Veranda extends Room {

    public final static Veranda INSTANCE = new Veranda();

    public Veranda() {
        name = "veranda";
        addPerson(Jane.INSTANCE);
    }

    @Override
    public void go(Manager manager, Room room) {
        manager.setCurrentRoom(room);
        manager.updateStory();
    }
}
