package jchopp.main.input;

import java.util.Collection;
import java.util.LinkedList;

public class SoftwareActions {

    protected LinkedList<String> actions = new LinkedList<>();

    public SoftwareActions(Collection<String> actionNames) {
        for (String action : actionNames) {
            actions.add(action);
        }
    }

    public SoftwareActions() {
        this(new LinkedList<String>());
    }

    public void addAction(String action) {
        actions.add(action);
    }

    public LinkedList<String> getActions() {
        return actions;
    }

}
