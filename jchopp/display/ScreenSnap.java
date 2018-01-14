package jchopp.display;

import jchopp.objects.graphical.GraphicalObject;
import jchopp.objects.logical.standards.AbstractLogicalObject;

import java.util.LinkedList;

public class ScreenSnap {

    private int screenRegister;

    private LinkedList<GraphicalObject> graphicalObjects;
    private LinkedList<AbstractLogicalObject> logicalObjects;

    public ScreenSnap(int screenRegister,
                      LinkedList<GraphicalObject> graphicalObjects,
                      LinkedList<AbstractLogicalObject> logicalObjects) {
        this.screenRegister = screenRegister;
        this.graphicalObjects = graphicalObjects;
        this.logicalObjects = logicalObjects;
    }

    public int getScreenRegister() {
        return screenRegister;
    }

    public LinkedList<GraphicalObject> getGraphicalObjects() {
        return graphicalObjects;
    }

    public LinkedList<AbstractLogicalObject> getLogicalObjects() {
        return logicalObjects;
    }
}
