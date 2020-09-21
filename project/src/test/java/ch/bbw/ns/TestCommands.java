package ch.bbw.ns;

import ch.bbw.ns.commands.Command;
import ch.bbw.ns.commands.GoCommand;
import ch.bbw.ns.commands.TalkCommand;
import ch.bbw.ns.commands.UseCommand;
import ch.bbw.ns.items.Item;

import ch.bbw.ns.rooms.Entrance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCommands {

    @Test
    public void testGoCommand() {
        Command c = Command.create("go to entrance", null);
        assertTrue(c instanceof GoCommand);
        GoCommand gc = (GoCommand) c;
        assertEquals(Entrance.INSTANCE, gc.getRoom());
    }

    @Test
    public void testTalkCommand() {
        Command c = Command.create("talk to jane", null);
        assertTrue(c instanceof TalkCommand);
        TalkCommand gc = (TalkCommand) c;
    }

    @Test
    public void testUseCommand() {
        Command c = Command.create("use phone", null);
        assertTrue(c instanceof UseCommand);
        UseCommand gc = (UseCommand) c;
    }

    @Test
    public void testWord_To() {
        testWrongFormat("go entrance");
        testWrongFormat("talk jane");
        testWrongFormat("go t entrance");
        testWrongFormat("talk tox jane");
    }

    private void testWrongFormat(String text) {
        try {
            Command c = Command.create(text, null);
            fail();
        } catch(CommandException e) {
        }
    }


}

