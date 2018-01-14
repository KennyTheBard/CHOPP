package jchopp.commands.commands.graphical;

import jchopp.strategies.interfaces.SelectFramesStrategy;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GraphicCommand {

    /**
     * The frame from the position indexNewFrames[i] will be changed
     * with the frame from newFrames[i].
     */
    private List<BufferedImage> newFrames;
    private List<Integer> indexNewFrames;

    private SelectFramesStrategy selectFramesStrategy;

    protected GraphicCommand(GraphicCommandBuilder builder) {
        this.newFrames = builder.newFrames;
        this.indexNewFrames = builder.indexNewFrames;
        this.selectFramesStrategy = builder.selectFramesStrategy;
    }

    /**
     * Builder Pattern constructor style in order to
     * break the construction in more steps without
     * losing the immutability of its fields.
     */
    public static class GraphicCommandBuilder {

        public GraphicCommandBuilder() { }

        protected List<BufferedImage> newFrames = new LinkedList<>();
        protected List<Integer> indexNewFrames = new LinkedList<>();
        protected SelectFramesStrategy selectFramesStrategy = null;

        public GraphicCommandBuilder putFrame(BufferedImage newFrame, int index) {
            for (int i : indexNewFrames) {
                if (i == index) {
                    newFrames.add(i, newFrame);
                    return this;
                }
            }
            newFrames.add(newFrame);
            indexNewFrames.add(index);
            return this;
        }

        public GraphicCommandBuilder putSelectFrameStrategy(
                    SelectFramesStrategy selectFramesStrategy) {
            this.selectFramesStrategy = selectFramesStrategy;
            return this;
        }

        public GraphicCommand build() {
            return new GraphicCommand(this);
        }

    }

    /**
     * This will change the existent frames with the indexes
     * in indexNewFrames with the new correspondent ones or
     * will add new ones at the end of the list if the indexes
     * are not occupied.
     * @param map ~ the list with changeable frames;
     */
    public void modifyFrames(HashMap<Integer, BufferedImage> map) {
        int n = indexNewFrames.size();
        int m = map.size();
        for (int i = 0; i < n; i++) {
            if (indexNewFrames.get(i) <= m) {
                map.put(indexNewFrames.get(i), newFrames.get(i));
            } else {
                map.put(map.size(), newFrames.get(i));
            }
        }
    }


    public SelectFramesStrategy getSelectFramesStrategy() {
        return selectFramesStrategy;
    }
}
