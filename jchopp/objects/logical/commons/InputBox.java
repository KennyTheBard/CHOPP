package jchopp.objects.logical.commons;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.input.InputDeviceData;
import jchopp.objects.auxiliars.IntegerRepresentedRectangle;
import jchopp.objects.graphical.GraphicalObject;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public class InputBox extends AbstractLogicalObject{
    public InputBox(IntegerRepresentedRectangle hitbox, GraphicalObject listener) {
        super(hitbox, listener);
    }

    @Override
    public void tick() {

    }

    @Override
    public void update() {

    }

    @Override
    public void sendCommand(LogicalCommand cmd) {

    }

    @Override
    public void passEvent(InputDeviceData data) {

    }
}
