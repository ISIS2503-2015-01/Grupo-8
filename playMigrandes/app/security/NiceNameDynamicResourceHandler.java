package security;

import play.mvc.Http;
import play.mvc.Http.Context;
import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.DeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;

public class NiceNameDynamicResourceHandler implements DynamicResourceHandler
{

	@Override
    public boolean isAllowed(final String name,
                             final String meta,
                             final DeadboltHandler deadboltHandler,
                             final Http.Context ctx)
    {
        final Subject subject = deadboltHandler.getSubject(ctx);
        return subject != null && subject.getIdentifier()
                                         .contains("greet");
    }

    @Override
    public boolean checkPermission(final String permissionValue,
                                   final DeadboltHandler deadboltHandler,
                                   final Http.Context ctx)
    {
        return false;
    }

}
