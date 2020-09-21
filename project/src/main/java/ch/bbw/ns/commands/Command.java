package ch.bbw.ns.commands;

import ch.bbw.ns.items.Item;
import ch.bbw.ns.rooms.Room;
import ch.bbw.ns.Manager;

/**
 * Command (Manages Commands)
 *
 * @author Noelle Senti
 * @version
 */

public abstract class Command {

    protected Manager manager;

    protected Command(Manager m) {
        this.manager = m;
    }

    public static Command create(String command, Manager manager) {
        String commandWord = command.split(" ")[0];
        switch (commandWord) {
            case "go":
                return new GoCommand(command, manager);
            case "talk":
                return new TalkCommand(command, manager);
            case "use":
                return new UseCommand(manager, command);
        }
        return null;
    }

    public abstract void applyToRoom(Room room, Manager manager);

}
