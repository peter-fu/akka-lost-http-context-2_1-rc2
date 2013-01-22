package controllers;

import play.Logger;
import play.libs.Akka;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import actions.AccessHttpContextAction;
import akka.AccessHttpContextActor;
import akka.actor.ActorRef;
import akka.actor.Props;

@With(AccessHttpContextAction.class)
public class Application extends Controller {

    public static Result index() {
        Logger.debug("Application.index");

        ActorRef sendActor = Akka.system().actorOf(new Props(AccessHttpContextActor.class));
        sendActor.tell(new Object(), sendActor);

        return ok();
    }

}
