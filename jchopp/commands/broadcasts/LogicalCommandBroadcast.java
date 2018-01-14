package jchopp.commands.broadcasts;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.control.ChoppMain;

public class LogicalCommandBroadcast {
    /**
     * Singleton implementation for gaining centralization
     * jchopp.main over distribution of jchopp.commands.commands.
     */

    private static LogicalCommandBroadcast instance;

    private LogicalCommandBroadcast() {

    }

    public static LogicalCommandBroadcast getInstance() {
        if (instance == null) {
            instance = new LogicalCommandBroadcast();
        }
        return instance;
    }

    /**
     * The effective functionalities of the broadcaster of jchopp.commands.commands.
     */

    private ChoppMain chop;

    public synchronized void setup(ChoppMain chop) {
        this.chop = chop;
    }

    public synchronized void acquireCommand(LogicalCommand cmd) {
        chop.acquireCommand(cmd);
    }

}
