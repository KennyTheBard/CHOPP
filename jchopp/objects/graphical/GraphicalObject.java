package jchopp.objects.graphical;

import jchopp.commands.commands.graphical.GraphicCommand;
import jchopp.objects.auxiliars.IntegerRepresentedRectangle;

import java.awt.Graphics;

/**
 * The graphical face of any logical object meant
 * to have a representation on screen.
 */
public class GraphicalObject {

    /**
     * The priority level of an object drawing.
     */
    protected int depth;

    public GraphicalObject(int depth) {
        this.depth = depth;
    }

    public GraphicalObject() {
        this(0);
    }

    public int getDepth() {
        return depth;
    }

    /**
     * The intended image or set of images which will
     * represent the logical object actions.
     */
    protected Sprite sprite = new Sprite();

    /**
     * The space in which the sprite will be rendered.
     */
    protected IntegerRepresentedRectangle hitbox = new IntegerRepresentedRectangle(0, 0, 1, 1);

    public void update(GraphicCommand command, IntegerRepresentedRectangle hitbox) {
        /** Updating the hotbox. */
        this.hitbox.move(hitbox.getX(), hitbox.getY());
        this.hitbox.resize(hitbox.getWidth(), hitbox.getHeight());

        /** Passing the jchopp.commands to the sprite. */
        sprite.update(command);
    }

    public void render(Graphics g) {
        sprite.render(g, hitbox);
    }

}
