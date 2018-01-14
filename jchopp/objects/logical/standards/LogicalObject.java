package jchopp.objects.logical.standards;

import jchopp.commands.commands.logical.LogicalCommand;
import jchopp.commands.broadcasts.LogicalCommandBroadcast;
import jchopp.main.input.InputDeviceData;
import jchopp.objects.auxiliars.IntegerRepresentedRectangle;
import jchopp.objects.graphical.GraphicalObject;
import jchopp.strategies.defaults.DefaultGraphicalCmdStrategy;
import jchopp.strategies.defaults.DefaultInputDataReactionStrategy;
import jchopp.strategies.defaults.DefaultLogicalCmdStrategy;
import jchopp.strategies.defaults.DefaultTickingStrategy;
import jchopp.strategies.interfaces.GraphicalCmdStrategy;
import jchopp.strategies.interfaces.InputDataReactionStrategy;
import jchopp.strategies.interfaces.LogicalCmdStrategy;
import jchopp.strategies.interfaces.TickingStrategy;

public class LogicalObject extends AbstractLogicalObject {

    private LogicalObject(LogicalObjectBuilder builder) {
        super(builder.hitbox, builder.listener);
        this.tickingStrategy = builder.tickingStrategy;
        this.graphicalCmdStrategy = builder.graphicalCmdStrategy;
        this.logicalCmdStrategy = builder.logicalCmdStrategy;
        this.inputReactionStrategy = builder.inputReactionStrategy;
        listener.update(graphicalCmdStrategy.getInitialCommand(), hitbox);
    }

    protected TickingStrategy tickingStrategy;

    @Override
    public void tick() {
        tickingStrategy.tick(this);
    }

    protected GraphicalCmdStrategy graphicalCmdStrategy;

    @Override
    public void update() {
        listener.update(graphicalCmdStrategy.getGraphicalCommand(), hitbox);
    }

    protected LogicalCmdStrategy logicalCmdStrategy;

    @Override
    public void sendCommand(LogicalCommand cmd) {
        LogicalCommandBroadcast.getInstance()
                .acquireCommand(logicalCmdStrategy.getLogicalCommand());
    }

    protected InputDataReactionStrategy inputReactionStrategy;

    @Override
    public void passEvent(InputDeviceData data) {
        inputReactionStrategy.reactToEvent(this, data);
    }

    /**
     * Builder Pattern constructor style in order to
     * break the construction in more steps without
     * losing the immutability of its fields.
     */
    public static class LogicalObjectBuilder {

        protected IntegerRepresentedRectangle hitbox;
        protected GraphicalObject listener;

        /** Responsible for generating actions in the Object. */
        protected TickingStrategy tickingStrategy = new DefaultTickingStrategy();
        /** Responsible for generating GraphicalCommands for the listener. */
        protected GraphicalCmdStrategy graphicalCmdStrategy = new DefaultGraphicalCmdStrategy();
        /** Responsible for generating LogicalCommand for the broadcaster. */
        protected LogicalCmdStrategy logicalCmdStrategy = new DefaultLogicalCmdStrategy();
        /** Responsible for reacting to input data passed from the InputDeviceReceiver. */
        protected InputDataReactionStrategy inputReactionStrategy = new DefaultInputDataReactionStrategy();

        public LogicalObjectBuilder putTickingStrategy(TickingStrategy tickingStrategy) {
            this.tickingStrategy = tickingStrategy;
            return this;
        }

        public LogicalObjectBuilder putGraphicalCmdStrategy(GraphicalCmdStrategy graphicalCmdStrategy) {
            this.graphicalCmdStrategy = graphicalCmdStrategy;
            return this;
        }

        public LogicalObjectBuilder putLogicalCmdStrategy(LogicalCmdStrategy logicalCmdStrategy) {
            this.logicalCmdStrategy = logicalCmdStrategy;
            return this;
        }

        public LogicalObjectBuilder putInputReactionStrategy(InputDataReactionStrategy inputReactionStrategy) {
            this.inputReactionStrategy = inputReactionStrategy;
            return this;
        }

        public LogicalObject build(IntegerRepresentedRectangle hitbox, GraphicalObject listener) {
            this.hitbox = hitbox;
            this.listener = listener;
            return new LogicalObject(this);
        }
    }
}
