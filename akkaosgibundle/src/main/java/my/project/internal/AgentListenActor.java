package my.project.internal;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by alm on 07.01.14.
 */
public class AgentListenActor extends UntypedActor {

    public static String listenActorName = "listenActor";

    @Override
    public void onReceive(Object o) throws Exception {
        LoggingAdapter log = Logging.getLogger(context().system(), this);
        if (o instanceof Message) {
            String message = ((Message) o).getMessageString();
            log.info("Message received: " + message);
        } else {
            unhandled(o);
        }
    }
}
