package jchopp.commands.commands.logical;

import jchopp.display.Screen;
import jchopp.display.ScreenManager;
import jchopp.main.control.ChoppMain;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public abstract class ControlCommand extends LogicalCommand {

    @Override
    public boolean execute(ChoppMain main) {
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
}
