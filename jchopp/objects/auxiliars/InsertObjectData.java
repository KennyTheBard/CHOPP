package jchopp.objects.auxiliars;

import jchopp.objects.logical.standards.AbstractLogicalObject;

public class InsertObjectData {

    protected AbstractLogicalObject object;

    public InsertObjectData(AbstractLogicalObject object) {
        this.object = object;
    }

    public AbstractLogicalObject getObject() {
        return object;
    }
}
