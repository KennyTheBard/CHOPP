package jchopp.main.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class InputDeviceData {

    private int currentMouseX, currentMouseY;
    private MouseEvent mousePressedEvent, mouseReleasedEvent;
    private MouseWheelEvent wheelEvent;
    private String pressedAction, releasedAction;

    public InputDeviceData(int currentMouseX, int currentMouseY,
               MouseEvent mousePressedEvent, MouseEvent mouseReleasedEvent,
                   MouseWheelEvent wheelEvent, String pressedAction,
                       String releasedAction) {
        this.currentMouseX = currentMouseX;
        this.currentMouseY = currentMouseY;
        this.mousePressedEvent = mousePressedEvent;
        this.mouseReleasedEvent = mouseReleasedEvent;
        this.wheelEvent = wheelEvent;
        this.pressedAction = pressedAction;
        this.releasedAction = releasedAction;
    }

    public int getCurrentMouseX() {
        return currentMouseX;
    }

    public int getCurrentMouseY() {
        return currentMouseY;
    }

    public MouseEvent getMousePressedEvent() {
        return mousePressedEvent;
    }

    public MouseEvent getMouseReleasedEvent() {
        return mouseReleasedEvent;
    }

    public MouseWheelEvent getWheelEvent() {
        return wheelEvent;
    }

    public String getPressedAction() {
        return pressedAction;
    }

    public String getReleasedAction() {
        return releasedAction;
    }
}
