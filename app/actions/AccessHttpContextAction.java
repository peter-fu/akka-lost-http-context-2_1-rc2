package actions;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;

import commons.Constants;

public class AccessHttpContextAction extends Action.Simple {

    @Override
    public Result call(Context context) throws Throwable {
        Logger.debug("AccessHttpContextAction.call");

        Logger.debug("  Setting current user to context as Foo");
        context.args.put(Constants.CONTEXT_KEY_CURRENT_USER, "Foo");

        // I try to access Context.current() here and it works!
        Logger.debug("  Fetch current user from Http.Context.current()");
        Logger.debug("  current user: " + Context.current().args.get(Constants.CONTEXT_KEY_CURRENT_USER));

        return delegate.call(context);
    }

}
