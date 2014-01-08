package my.project.internal;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.osgi.ActorSystemActivator;
import org.osgi.framework.BundleContext;

/**
 * Extension of the default OSGi bundle activator
 */
public final class AkkaActivator extends ActorSystemActivator {

    private ActorRef actorListenService;

    @Override
    public void configure(BundleContext bundleContext, ActorSystem actorSystem) {
//        LoggingAdapter log = Logging.apply(actorSystem, this, null);
        LoggingAdapter log = Logging.getLogger(actorSystem, this);
        log.info("Registering Actor System...");
        Props props = Props.create(AgentListenActor.class);
        actorListenService = actorSystem.actorOf(props, "actorListen");
        registerService(bundleContext, actorSystem);
        log.info("Actor System registered.");
    }
}

