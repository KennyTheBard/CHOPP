package jchopp.main.config;

import jchopp.display.ScreenSnap;
import jchopp.main.input.SoftwareActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Configuration {

    /**
     * Serves as a temporary container for program configurations.
     */

    protected int windowWidth, windowHeight, tickPerSecond, enterScreenRegister;
    protected Collection<ScreenSnap> snaps;
    protected SoftwareActions actions;

    private Configuration(ConfigurationBuilder builder) {
        this.windowWidth = builder.windowWidth;
        this.windowHeight = builder.windowHeight;
        this.tickPerSecond = builder.tickPerSecond;
        this.enterScreenRegister = builder.enterScreenRegister;
        this.snaps = builder.snaps;
        this.actions = builder.actions;
    }

    public void resetConfiguration() {
        GlobalConfiguration.getInstance().setWindowWidth(windowWidth);
        GlobalConfiguration.getInstance().setWindowHeight(windowHeight);
        GlobalConfiguration.getInstance().setTickPerSecond(tickPerSecond);
    }

    public SoftwareActions getProgramActions() {
        return actions;
    }

    public Collection<ScreenSnap> getSnaps() {
        return snaps;
    }

    public int getEnterScreenRegister() {
        return enterScreenRegister;
    }

    public static class ConfigurationBuilder {

        protected int windowWidth = 640,
                    windowHeight = 480,
                    tickPerSecond = 30,
                    enterScreenRegister = 0;
        protected Collection<ScreenSnap> snaps;
        protected SoftwareActions actions;

        public ConfigurationBuilder() { }

        public ConfigurationBuilder setWidth(int width) {
            this.windowWidth = width;
            return this;
        }

        public ConfigurationBuilder setHeight(int height) {
            this.windowHeight = height;
            return this;
        }

        public ConfigurationBuilder setTicks(int ticks) {
            this.tickPerSecond = ticks;
            return this;
        }

        public ConfigurationBuilder setEnterScreenRegister(int enterScreenRegister) {
            this.enterScreenRegister = enterScreenRegister;
            return this;
        }

        public ConfigurationBuilder addSnap(ScreenSnap snap) {
            if (snaps == null) {
                snaps = new LinkedList<>();
            }
            snaps.add(snap);
            return this;
        }

        public ConfigurationBuilder setActions(SoftwareActions actions) {
            this.actions = actions;
            return this;
        }

        public Configuration build() {
            if (snaps == null) {
                snaps = new ArrayList<>(
                        Arrays.asList(new ScreenSnap(
                                0, new LinkedList<>(),
                                new LinkedList<>())));
            }
            if (actions == null) {
                actions = new SoftwareActions();
            }
            return new Configuration(this);
        }

    }
}
