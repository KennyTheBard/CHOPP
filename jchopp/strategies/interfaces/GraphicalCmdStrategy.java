package jchopp.strategies.interfaces;

import jchopp.commands.commands.graphical.GraphicCommand;

public interface GraphicalCmdStrategy {

    GraphicCommand getGraphicalCommand();

    GraphicCommand getInitialCommand();

}
