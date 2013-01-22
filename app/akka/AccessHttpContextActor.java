package akka;

import play.mvc.Http.Context;
import akka.actor.UntypedActor;

public class AccessHttpContextActor extends UntypedActor {

    public AccessHttpContextActor() {}

    @Override
    public void onReceive(Object arg0) throws Exception {

        // I try to access Context.curent() here, but it doesn't work
        System.out.println(Context.current());

    }

}
