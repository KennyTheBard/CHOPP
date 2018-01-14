package jchopp.commands.commands.logical;

import jchopp.display.Screen;
import jchopp.display.ScreenManager;
import jchopp.main.control.Handler;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public abstract class SystemCommand extends LogicalCommand {

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
}
