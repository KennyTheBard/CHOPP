package jchopp.main.input;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;

public class ActionInputMap {

    protected LinkedList<String> actions = new LinkedList<>();
    /**
     * The first integer is the key code of the event, and the second
     * is the position of the action in the collection of actions.
     */
    protected HashMap<Integer, Integer> events = new HashMap<>();

    public ActionInputMap(SoftwareActions actions) {
        for (String action : actions.getActions()) {
            this.actions.add(action);
        }
    }

    public void setActionKey(String action, int keyCode) {
        int idx = actions.indexOf(action);
        if (idx == -1) {
            return;
        }
        events.put(keyCode, idx);
    }

    public String getAction(KeyEvent event) {
        if (event == null) {
            return null;
        }
        if (events.get(event.getKeyCode()) == null) {
            return null;
        }
        return actions.get(events.get(event.getKeyCode()));
    }

}
