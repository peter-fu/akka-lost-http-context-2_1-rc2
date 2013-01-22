package akka;

import play.Logger;
import play.mvc.Http.Context;
import akka.actor.UntypedActor;

public class AccessHttpContextActor extends UntypedActor {

    public AccessHttpContextActor() {}

    @Override
    public void onReceive(Object arg0) throws Exception {
        Logger.debug("AccessHttpContextActor.onReceive");

        Logger.debug("  Try to access Context.curent()");
        System.out.println(Context.current());
    }

}
