package ch.bbw.ns.commands;

import ch.bbw.ns.CommandException;
import ch.bbw.ns.Manager;
import ch.bbw.ns.items.Item;
import ch.bbw.ns.people.Person;
import ch.bbw.ns.rooms.Room;

public class UseCommand extends Command {
    private Item item;

    public UseCommand(Manager m, String command) {
        super(m);
        String[] splitCommand = command.split(" ");

        if (splitCommand.length != 2) {
            throw new CommandException("The use command must be in the format 'use ITEM'");
        }

        try {
            item = Item.valueOf(splitCommand[1].toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CommandException(splitCommand[1] + " is an unknown item");
        }
    }

    @Override
    public void applyToRoom(Room room, Manager manager) {
        room.use(manager, item);
    }
}
