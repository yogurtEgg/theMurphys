package ch.bbw.ns.people;

import ch.bbw.ns.Manager;
import ch.bbw.ns.items.Item;
import ch.bbw.ns.rooms.Entrance;

/**
 * Jane
 *
 * @author Noelle Senti
 * @version
 */

public class Jane extends Person {
    public final static Jane INSTANCE = new Jane();

    @Override
    public String getName() {
        return "Jane";
    }
}
