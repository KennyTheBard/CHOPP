package jchopp.commands.commands.logical;

import jchopp.main.control.ChoppMain;
import jchopp.main.control.Handler;
import jchopp.display.Screen;
import jchopp.display.ScreenManager;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public abstract class LogicalCommand {

    public abstract boolean execute (ChoppMain main);

    public abstract boolean execute(Handler handler);

    public abstract boolean execute(ScreenManager manager);

    public abstract boolean execute(Screen screen);

    public abstract boolean execute(AbstractLogicalObject object);

}
