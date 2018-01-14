package jchopp.commands.commands.logical;

import jchopp.display.Screen;
import jchopp.display.ScreenManager;
import jchopp.main.control.ChoppMain;
import jchopp.main.control.Handler;

public abstract class LocalCommand extends LogicalCommand {

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
}
