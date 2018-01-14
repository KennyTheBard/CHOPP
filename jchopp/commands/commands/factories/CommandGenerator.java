package jchopp.commands.commands.factories;

import jchopp.commands.commands.logical.LocalDisplayCommand;
import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.display.Screen;
import jchopp.objects.auxiliars.InsertObjectData;

public class CommandGenerator {

    /**
     * Singleton aspect of the class.
     */

    private static CommandGenerator instance;

    private CommandGenerator() { }

    public static CommandGenerator getInstance() {
        if (instance == null) {
            instance = new CommandGenerator();
        }
        return instance;
    }

    /**
     * Factory aspect of the class.
     */

    public enum GenericCommandType {
        INSERT_OBJECT,
        DELETE_OBJECT
    }

    public LogicalCommand getLogicalCommand(GenericCommandType type, Object arg) {
        switch (type) {
            case INSERT_OBJECT:
                return new LocalDisplayCommand() {
                    @Override
                    public boolean execute(Screen screen) {
                        screen.addLogicalObject(((InsertObjectData)arg).getObject());
                        return true;
                    }
                };
            case DELETE_OBJECT:
                return new LocalDisplayCommand() {
                    @Override
                    public boolean execute(Screen screen) {
                        // TODO
                        return true;
                    }
                };
            default:
                throw new IllegalArgumentException("This generic command type is not supported!");
        }
    }

}
