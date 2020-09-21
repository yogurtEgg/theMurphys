package ch.bbw.ns;

/**
 * CommandExcpetion (manages messages if a command is not valid)
 *
 * @author Noelle Senti
 * @version
 */
public class CommandException extends RuntimeException {
    public CommandException(String errorMsg) {
        super(errorMsg);
    }
}
