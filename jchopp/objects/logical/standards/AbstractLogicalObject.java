package jchopp.objects.logical.standards;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.input.InputDeviceData;
import jchopp.objects.auxiliars.IntegerRepresentedRectangle;
import jchopp.objects.graphical.GraphicalObject;


public abstract class AbstractLogicalObject {

    protected IntegerRepresentedRectangle hitbox;

    protected GraphicalObject listener;

    public AbstractLogicalObject(IntegerRepresentedRectangle hitbox, GraphicalObject listener) {
        this.hitbox = hitbox;
        this.listener = listener;
    }

    public IntegerRepresentedRectangle getHitbox() {
        return hitbox;
    }

    public GraphicalObject getListener() {
        return listener;
    }

    public abstract void tick();

    public abstract void update();

    public abstract void sendCommand(LogicalCommand cmd);

    public abstract void passEvent(InputDeviceData data);
}
