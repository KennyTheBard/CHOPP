package jchopp.display;

import jchopp.commands.commands.logical.LogicalCommand;

import java.awt.Graphics;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public class ScreenManager {

    public ScreenManager(Collection<ScreenSnap> snaps, int enterScreenRegister) {
        library = new SnapLibrary(snaps);
        pool.put(enterScreenRegister, new Screen(library.extractSnap(enterScreenRegister)));
    }

    /**
     * All screen instances that will be rendered will be kept
     * here, the ones that would be ticked will be selected
     * from this container with the help of a user-defined
     * strategy. The depth layer system of screens will be
     * defined by the natural order in the Deque, the first
     * screen will be the front one, the last screen will be
     * the most in the back.
     */
    private TreeMap<Integer, Screen> pool = new TreeMap<>();

    private SnapLibrary library;

    public void removeScreen(int screenRegister) {
        Screen screen = pool.get(screenRegister);
        if (screen != null) {
            pool.remove(screen);
        }
    }

    public void insertScreen(int screenRegister) {
        ScreenSnap snap = library.extractSnap(screenRegister);
        if (snap != null) {
            pool.put(screenRegister, new Screen(snap));
        }
    }

    public void render(Graphics g) {
        Set<Integer> set = pool.descendingKeySet();
        for (int i : set) {
            pool.get(i).render(g);
        }
    }

    public void tick() {
        getCurrentScreen().tick();
    }

    public void acquireCommand(LogicalCommand cmd) {
        cmd.execute(this);
    }

    public Screen getCurrentScreen() {
        return pool.firstEntry().getValue();
    }
}
