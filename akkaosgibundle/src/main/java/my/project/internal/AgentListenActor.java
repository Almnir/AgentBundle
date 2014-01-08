package my.project.internal;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by alm on 07.01.14.
 */
public class AgentListenActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        LoggingAdapter log = Logging.apply(context().system(), this, null);
        if (o instanceof String) {
            String message = (String) o;
            log.info("Message received: ");
            log.info(message);
        }
    }
}
