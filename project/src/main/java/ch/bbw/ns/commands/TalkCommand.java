package ch.bbw.ns.commands;

import ch.bbw.ns.CommandException;
import ch.bbw.ns.Manager;
import ch.bbw.ns.items.Item;
import ch.bbw.ns.people.Person;
import ch.bbw.ns.rooms.Room;

public class TalkCommand extends Command{
    private Person person;
    private Manager manager;

    public TalkCommand(String command, Manager m) {
        super(m);
        String[] splitCommand = command.split(" ");

        if(splitCommand.length != 3 || !splitCommand[1].equals("to")) {
            throw new CommandException("The talk command must be in the format 'talk to PERSON'");
        }

        try {
            person = Person.get(splitCommand[2]);
        } catch(IllegalArgumentException e) {
            throw new CommandException(splitCommand[2] + " is an unknown person");
        }
    }

    @Override
    public void applyToRoom(Room room, Manager manager) {
        room.talk(manager, person);
    }
}
