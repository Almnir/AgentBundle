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
        LoggingAdapter log = Logging.getLogger(actorSystem, this);
        log.info("Registering Listening Actor as a service...");
        ActorSystem remoteSystem = ActorSystem.create("remote");
        Props props = Props.create(AgentListenActor.class);
        remoteSystem.actorOf(props, AgentListenActor.listenActorName);
        registerService(bundleContext, remoteSystem);
        log.info("Actor System registered: " + remoteSystem.name());
        log.info("Listening Actor as a service registered: " + AgentListenActor.listenActorName);
/*
        // listen actor properties
        Props props = Props.create(AgentListenActor.class);
        actorListenService = actorSystem.actorOf(props, AgentListenActor.listenActorName);
        // registering as an osgi service
        registerService(bundleContext, actorSystem);
        log.info("Actor System registered: " + actorSystem.name());
        log.info("Listening Actor as a service registered: " + AgentListenActor.listenActorName);
*/
    }
}

