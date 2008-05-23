package org.xwiki.velocity;

import org.apache.velocity.VelocityContext;
import org.xwiki.container.Request;
import org.xwiki.container.RequestInitializer;
import org.xwiki.container.RequestInitializerException;

/**
 * Allow registering the Velocity Context in the XWiki Request object since it's shared during the
 * whole request.
 *
 * @see org.xwiki.container.RequestInitializerManager
 * @see RequestInitializer
 * @since 1.5M1
 * @version $Id: $
 */
public class VelocityRequestInitializer implements RequestInitializer
{
    /**
     * The id under wich the Velocity Context is stored in the Request.
     */
    public static final String REQUEST_VELOCITY_CONTEXT = "velocityContext";

    /**
     * The Velocity context factory component used for creating the Velocity Context (injected
     * automatically by the Component subsystem).
     */
    private VelocityContextFactory velocityContextFactory;

    /**
     * {@inheritDoc}
     *
     * @see org.xwiki.container.RequestInitializer#initialize(org.xwiki.container.Request)
     */
    public void initialize(Request request) throws RequestInitializerException
    {
        try {
            VelocityContext context = this.velocityContextFactory.createContext();
            request.setProperty(VelocityRequestInitializer.REQUEST_VELOCITY_CONTEXT, context);
        } catch (XWikiVelocityException e) {
            throw new RequestInitializerException("Failed to initialize Velocity Context", e);
        }
    }
}
