package jchopp.objects.graphical;

import jchopp.commands.commands.graphical.GraphicCommand;
import jchopp.objects.auxiliars.IntegerRepresentedRectangle;
import jchopp.strategies.defaults.DefaultSelectFramesStrategy;
import jchopp.strategies.interfaces.SelectFramesStrategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Sprite {
    /**
     * Container class for different types of images such
     * as PNG or GIF. Can hold animations too, selecting
     * and playing them according to it's SelectFrameStrategy.
     */
    private HashMap<Integer, BufferedImage> frames = new HashMap<>();

    private SelectFramesStrategy selectFramesStrategy = new DefaultSelectFramesStrategy();

    public void render(Graphics g, IntegerRepresentedRectangle hitbox) {
        int idx = selectFramesStrategy.selectFrame();
        if (idx == -1) {
            return;
        } else {
            g.drawImage(frames.get(idx), hitbox.getX(), hitbox.getY(), null);
        }
    }

    /**
     * Getting and applying updates over the frame list
     * according to the jchopp.commands received from the logical
     * object it is observing.
     * @param command ~ the container for updated data;
     */
    public void update(GraphicCommand command) {
        if (command.getSelectFramesStrategy() != null) {
            this.selectFramesStrategy = command.getSelectFramesStrategy();
        }
        command.modifyFrames(frames);
        selectFramesStrategy.setNumberOfFrames(frames.size());
    }

}
