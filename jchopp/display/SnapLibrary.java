package jchopp.display;

import java.util.Collection;
import java.util.HashMap;


public class SnapLibrary {

    private HashMap<Integer, ScreenSnap> snaps = new HashMap<>();

    public SnapLibrary(Collection<ScreenSnap> snaps) {
        for (ScreenSnap snap : snaps) {
            this.snaps.put(snap.getScreenRegister(), snap);
        }
    }

    public ScreenSnap extractSnap(int screenRegister) {
        return snaps.get(screenRegister);
    }

    public void insertSnap(ScreenSnap snap) {
        snaps.put(snap.getScreenRegister(), snap);
    }

    public void deleteSnap(int screenRegister) {
        snaps.remove(screenRegister);
    }
}
