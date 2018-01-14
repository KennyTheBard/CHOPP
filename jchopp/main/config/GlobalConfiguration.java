package jchopp.main.config;

public class GlobalConfiguration {

    /**
     * Singleton implementation of a configuration class
     * for the GUI.
     */
    private static GlobalConfiguration instance;

    /**
     * Should initialise the fields with default value.
     */
    private GlobalConfiguration() {

    }

    public static GlobalConfiguration getInstance() {
        if (instance == null) {
            instance = new GlobalConfiguration();
        }
        return instance;
    }

    /**
     *  Configuration fields and methods to configure.
     */
    private int windowWidth, windowHeight, tickPerSecond;

    public void setup(int windowWidth, int windowHeight, int tickPerSecond) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.tickPerSecond = tickPerSecond;
    }

    public void setup(int windowWidth, int windowHeight) {
        setup(windowWidth, windowHeight, 60);
    }

    public void setup() {
        setup(1024, 768, 60);
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getTickPerSecond() {
        return tickPerSecond;
    }

    public void setTickPerSecond(int tickPerSecond) {
        this.tickPerSecond = tickPerSecond;
    }
}
