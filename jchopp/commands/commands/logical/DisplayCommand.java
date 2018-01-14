package jchopp.commands.commands.logical;

import jchopp.main.control.ChoppMain;
import jchopp.main.control.Handler;
import jchopp.display.Screen;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public abstract class DisplayCommand extends LogicalCommand {

    @Override
    public boolean execute(ChoppMain main) {
        return false;
    }

    @Override
    public boolean execute(Handler handler) {
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
