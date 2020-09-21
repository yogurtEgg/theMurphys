package ch.bbw.ns.commands;

import ch.bbw.ns.CommandException;
import ch.bbw.ns.Manager;
import ch.bbw.ns.people.Person;
import ch.bbw.ns.rooms.Room;

public class GoCommand extends Command{
    private Room goTo;

    public GoCommand(String command, Manager m) {
        super(m);
        String[] splitCommand = command.split(" ");

        if(splitCommand.length != 3 || !splitCommand[1].equals("to")) {
            throw new CommandException("The talk command must be in the format 'go to ROOM'");
        }

        try {
            goTo = Room.get(splitCommand[2]);
        } catch(IllegalArgumentException e) {
            throw new CommandException(splitCommand[2] + " is an unknown Room");
        }
    }

    public Room getRoom() {
        return goTo;
    }

    public void setRoom(Room goTo) {
        this.goTo = goTo;
    }

    @Override
    public void applyToRoom(Room room, Manager manager) {
room.go(manager, goTo);
    }
}
