package jchopp.display;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.input.InputDeviceData;
import jchopp.objects.graphical.GraphicalObject;
import jchopp.objects.logical.standards.AbstractLogicalObject;

import java.awt.Graphics;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Screen {

    /**
     * The register of the screen playing the role of an UID.
     */
    private int screenRegister;

    /**
     * List of all graphical object this screen will manage.
     */
    private PriorityQueue<GraphicalObject> graphicalObjects;
    private LinkedList<AbstractLogicalObject> logicalObjects;

    public Screen(ScreenSnap snap) {
        this.screenRegister = snap.getScreenRegister();
        this.graphicalObjects = createQueueWithComparator();
        for (GraphicalObject obj : snap.getGraphicalObjects()) {
            graphicalObjects.add(obj);
        }
        this.logicalObjects = snap.getLogicalObjects();
    }

    private PriorityQueue<GraphicalObject> createQueueWithComparator() {
        return new PriorityQueue<>(new Comparator<GraphicalObject>() {
            @Override
            public int compare(GraphicalObject obj1, GraphicalObject obj2) {
                if (obj1.getDepth() > obj2.getDepth()) {
                    return -1;
                } else if (obj1.getDepth() < obj2.getDepth()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    /**
     * Constructor destined for creating new screens.
     * @param screenRegister the register of the new screen
     */
    public Screen(int screenRegister) {
        this.screenRegister = screenRegister;
        this.graphicalObjects = createQueueWithComparator();
        this.logicalObjects = new LinkedList<>();
    }

    public int getScreenRegister() {
        return screenRegister;
    }

    /**
     * Removes a graphical object which is no more useful.
     * @param object ~ reference of the object to be removed.
     */
    private void removeGraphicalObject(GraphicalObject object) {
        graphicalObjects.remove(object);
    }

    /**
     * Adds a new logical object into the list.
     */
    public void addLogicalObject(AbstractLogicalObject object) {
        logicalObjects.add(object);
        graphicalObjects.add(object.getListener());
    }

    /**
     * Adds a the logical object from the container to the list.
     */
    public void addLogicalObject(Collection<AbstractLogicalObject> objects) {
        for (AbstractLogicalObject object : objects) {
            logicalObjects.add(object);
        }
    }

    /**
     * Removes a logical object which is no more useful.
     * @param object ~ reference of the object to be removed.
     */
    public void removeLogicalObject(AbstractLogicalObject object) {
        logicalObjects.remove(object);
        removeGraphicalObject(object.getListener());
    }

    public void render(Graphics g) {
        for (GraphicalObject object : graphicalObjects) {
            object.render(g);
        }
    }

    public void tick() {
        for (AbstractLogicalObject object : logicalObjects) {
            object.tick();
        }
    }

    public void acquireCommand(LogicalCommand cmd) {
        if (!cmd.execute(this)) {

        }
    }

    public ScreenSnap snap() {
        LinkedList<GraphicalObject> list = new LinkedList<>();
        for (GraphicalObject obj : graphicalObjects) {
            list.add(obj);
        }
        return new ScreenSnap(screenRegister, list , logicalObjects);
    }

    public void passEvent(InputDeviceData data) {
        for (AbstractLogicalObject object : logicalObjects) {
            object.passEvent(data);
        }
    }
}
