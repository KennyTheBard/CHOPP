package jchopp.strategies.interfaces;

public interface SelectFramesStrategy {
    /**
     * Strategy Pattern for choosing the right frames to render.
     */

    int selectFrame();

    void setNumberOfFrames(int numFrames);
}
