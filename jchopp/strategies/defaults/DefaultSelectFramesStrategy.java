package jchopp.strategies.defaults;

import jchopp.strategies.interfaces.SelectFramesStrategy;

public class DefaultSelectFramesStrategy implements SelectFramesStrategy {

    private int currentFrame = -1, numFrames = 0;

    @Override
    public int selectFrame() {
        if (numFrames == 0) {
            return -1;
        } else {
            int idx = currentFrame;
            currentFrame++;
            if (currentFrame >= numFrames) {
                currentFrame = 0;
            }
            return idx;
        }

    }

    @Override
    public void setNumberOfFrames(int numFrames) {
        this.numFrames = numFrames;
    }

}
