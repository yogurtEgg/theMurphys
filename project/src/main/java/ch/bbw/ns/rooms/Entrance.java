package ch.bbw.ns.rooms;

import ch.bbw.ns.items.Item;

import ch.bbw.ns.Manager;

/**
 * Entrance, Room
 *
 * @author Noelle Senti
 */

public class Entrance extends Room {

    public final static Entrance INSTANCE = new Entrance();


    public Entrance() {
        name = "entrance";
        rooms.add(Veranda.INSTANCE);
    }

}
