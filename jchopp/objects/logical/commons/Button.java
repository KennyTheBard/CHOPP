package jchopp.objects.logical.commons;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.input.InputDeviceData;
import jchopp.objects.auxiliars.IntegerRepresentedRectangle;
import jchopp.objects.graphical.GraphicalObject;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public class Button extends AbstractLogicalObject {
    public Button(ButtonBuilder builder) {
        super(builder.hitbox, builder.listener);
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

    public static class ButtonBuilder {

        protected IntegerRepresentedRectangle hitbox;
        protected GraphicalObject listener;

    }
}
