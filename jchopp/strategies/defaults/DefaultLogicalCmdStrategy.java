package jchopp.strategies.defaults;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.control.ChoppMain;
import jchopp.main.control.Handler;
import jchopp.display.Screen;
import jchopp.display.ScreenManager;
import jchopp.objects.logical.standards.AbstractLogicalObject;
import jchopp.strategies.interfaces.LogicalCmdStrategy;

public class DefaultLogicalCmdStrategy implements LogicalCmdStrategy {
    @Override
    public LogicalCommand getLogicalCommand() {
        return new LogicalCommand() {

            @Override
            public boolean execute(ChoppMain main) {
                return false;
            }

            @Override
            public boolean execute(Handler handler) {
                return false;
            }

            @Override
            public boolean execute(ScreenManager manager) {
                return false;
            }

            @Override
            public boolean execute(Screen screen) {
                return false;
            }

            @Override
            public boolean execute(AbstractLogicalObject object) {
                return false;
            }
        };
    }
}
