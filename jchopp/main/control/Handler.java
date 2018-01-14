package jchopp.main.control;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.input.InputDeviceReceiver;
import jchopp.main.input.SoftwareActions;
import jchopp.display.ScreenManager;
import jchopp.display.ScreenSnap;

import java.awt.*;
import java.util.Collection;

public class Handler{
    /**
     *  Manages renderings and ticks in order to have them
     *  called only for the elements of the current screen.
     */

    private ScreenManager manager;
    private InputDeviceReceiver receiver;

    public Handler(Collection<ScreenSnap> snaps, int enterScreenRegister) {
        manager = new ScreenManager(snaps, enterScreenRegister);
    }

    public void setInputDeviceReceiver(Canvas frame, SoftwareActions actions) {
        receiver = new InputDeviceReceiver(this, frame, actions);
    }
    /**
     * A chain of jchopp.commands form of commanding the system.
     */

    public void render(Graphics g) {
        manager.render(g);
    }

    public void tick() {
        manager.tick();
    }

    public void passEvent() {
        manager.getCurrentScreen().passEvent(receiver.getData());
    }

    public void acquireCommand(LogicalCommand cmd) {
        if (!cmd.execute(this)) {
            manager.acquireCommand(cmd);
            manager.getCurrentScreen().acquireCommand(cmd);
        }
    }

    public void setActionKey(String action, int keyCode) {
        receiver.setActionKey(action, keyCode);
    }
}
