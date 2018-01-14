package jchopp.strategies.defaults;

import jchopp.commands.commands.graphical.GraphicCommand;
import jchopp.strategies.interfaces.GraphicalCmdStrategy;

public class DefaultGraphicalCmdStrategy implements GraphicalCmdStrategy {

    @Override
    public GraphicCommand getGraphicalCommand() {
        return new GraphicCommand.GraphicCommandBuilder().build();
    }

    @Override
    public GraphicCommand getInitialCommand() {
        return new GraphicCommand.GraphicCommandBuilder().build();
    }
}
