package jchopp.strategies.interfaces;

import jchopp.main.input.InputDeviceData;
import jchopp.objects.logical.standards.AbstractLogicalObject;

public interface InputDataReactionStrategy {

    void reactToEvent(AbstractLogicalObject object, InputDeviceData data);

}
