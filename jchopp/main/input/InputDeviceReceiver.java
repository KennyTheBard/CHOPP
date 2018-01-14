package jchopp.main.input;

import jchopp.main.control.Handler;

import java.awt.Canvas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayDeque;

public class InputDeviceReceiver {

    protected Handler handler;
    protected Canvas frame;
    protected ActionInputMap inputMap;

    protected ArrayDeque<MouseEvent> mousePressedEvents = new ArrayDeque<>();
    protected ArrayDeque<MouseEvent> mouseReleasedEvents = new ArrayDeque<>();
    protected ArrayDeque<MouseWheelEvent> wheelEvents = new ArrayDeque<>();
    protected ArrayDeque<String> pressedActions = new ArrayDeque<>();
    protected ArrayDeque<String> releasedActions = new ArrayDeque<>();

    public InputDeviceReceiver(Handler handler, Canvas frame, SoftwareActions actions) {
        this.handler = handler;
        this.inputMap = new ActionInputMap(actions);
        this.frame = frame;
        createListeners();
    }

    protected void createListeners() {
        if (frame == null) {
            return;
        }

        /**
         * Mouse events will be listened and directly be send further.
         */
        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                mousePressedEvents.push(mouseEvent);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                mouseReleasedEvents.push(mouseEvent);
            }

        });

        frame.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
                wheelEvents.push(mouseWheelEvent);
            }
        });

        /**
         * Keyboard inputs will be received and the corespondent action
         * will be searched and send further.
         */
        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                String action = inputMap.getAction(keyEvent);
                if (action != null) {
                    pressedActions.push(inputMap.getAction(keyEvent));
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                String action = inputMap.getAction(keyEvent);
                if (action != null) {
                    releasedActions.push(inputMap.getAction(keyEvent));
                }
            }
        });
    }

    public InputDeviceData getData() {

        /** Check if there are mouse events to pass further. */
        MouseEvent pressMouse = null, releaseMouse = null;
        if (!mousePressedEvents.isEmpty()) {
            pressMouse = mousePressedEvents.pop();
        }
        if (!mouseReleasedEvents.isEmpty()) {
            releaseMouse = mouseReleasedEvents.pop();
        }

        /** Check if there are mouse wheel events to pass further. */
        MouseWheelEvent wheel = null;
        if (!wheelEvents.isEmpty()) {
            wheel = wheelEvents.pop();
        }

        /** Check if there are actions to pass further. */
        String pressKey = null, releaseKey = null;
        if (!pressedActions.isEmpty()) {
            pressKey = pressedActions.pop();
        }
        if (!releasedActions.isEmpty()) {
            releaseKey = releasedActions.pop();
        }

        /** Passing the structure of actions and events. */
        return new InputDeviceData(
                new Double(frame.getLocationOnScreen().getX()).intValue(),
                new Double(frame.getLocationOnScreen().getY()).intValue(),
                pressMouse, releaseMouse, wheel, pressKey, releaseKey);
    }

    public void setActionKey(String action, int keyCode) {
        inputMap.setActionKey(action, keyCode);
    }
}
