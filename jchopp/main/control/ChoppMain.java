package jchopp.main.control;

import jchopp.commands.broadcasts.LogicalCommandBroadcast;
import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.main.config.Configuration;
import jchopp.main.config.GlobalConfiguration;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class ChoppMain extends Canvas implements Runnable {
    /**
     *  Main class for the graphical module.
     */

    private Thread thread;
    private boolean running, exit = false;
    private Handler handler;

    public ChoppMain(Configuration config) {

        config.resetConfiguration();

        handler = new Handler(config.getSnaps(), config.getEnterScreenRegister());
        handler.setInputDeviceReceiver(this, config.getProgramActions());

        new Window(GlobalConfiguration.getInstance().getWindowWidth(),
                GlobalConfiguration.getInstance().getWindowHeight(),
                "Test ChoppMain",this);
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 100000000;
        double delta = 0;
        render();
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 2) {
                render();
                tick();
                passEvent();
                delta -= 2;
            }
            if (exit) {
                break;
            }
        }
        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        LogicalCommandBroadcast.getInstance().setup(this);

        running = true;
    }

    public synchronized void exit() {
        exit = true;
        running = false;
    }

    public synchronized void stop() {
        try {
            running = false;
            thread.interrupt();
            System.exit(0);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0, GlobalConfiguration.getInstance().getWindowWidth(),
                GlobalConfiguration.getInstance().getWindowHeight());

        handler.render(g);


        g.dispose();
        bs.show();

        Toolkit.getDefaultToolkit().sync();
    }

    private void tick() {
        handler.tick();
    }

    private void passEvent() {
        handler.passEvent();
    }

    public void setActionKey(String action, int keyCode) {
        handler.setActionKey(action, keyCode);
    }

    public void acquireCommand(LogicalCommand cmd) {
        if (!cmd.execute(this)) {
            handler.acquireCommand(cmd);
        }
    }
}
