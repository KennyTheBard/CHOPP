package jchopp.commands.commands.logical;

import jchopp.main.control.ChoppMain;
import jchopp.main.control.Handler;
import jchopp.display.ScreenManager;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public abstract class LocalDisplayCommand extends LogicalCommand {

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
    public boolean execute(AbstractLogicalObject object) {
        return false;
    }
}
